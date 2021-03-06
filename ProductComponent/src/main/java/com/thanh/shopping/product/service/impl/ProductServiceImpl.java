package com.thanh.shopping.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.product.domain.Product;
import com.thanh.shopping.product.domain.Stock;
import com.thanh.shopping.product.dto.OrderedProductDTO;
import com.thanh.shopping.product.dto.ProductDTO;
import com.thanh.shopping.product.repository.ProductRepository;
import com.thanh.shopping.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	@Qualifier("productMapper")
	private DtoMapper<Product, ProductDTO> dtoMapper;

	@Override
	public void addProduct(ProductDTO productDTO) {
		Product product = getProduct(productDTO.getProductNumber());
		if (product != null) {
			// Product is existed. Should throw exception here
		}
		else {
			product = dtoMapper.toEntity(productDTO);
			productRepository.insert(product);
		}
	}

	@Override
	public ProductDTO getProductDTO(String productNumber) {
		Optional<Product> optProduct = productRepository.findById(productNumber);
		if (optProduct.isPresent()) {
			return dtoMapper.toDTO(optProduct.get());
		}
		return null;
	}

	@Override
	public void setStock(Long quantity, String locationCode, String productNumber) {
		Product product = getProduct(productNumber);
		if (product == null) {
			throw new NullPointerException("Invalid product number");
		}
		Stock stock = new Stock();
		stock.setLocationCode(locationCode);
		stock.setQuantity(quantity);
		product.setStock(stock);
		productRepository.save(product);
	}
	
	@Override
	public Product getProduct(String productNumber) {
		Optional<Product> optProduct = productRepository.findById(productNumber);
		if (optProduct.isPresent()) {
			return optProduct.get();
		}
		return null;
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		Product product = getProduct(productDTO.getProductNumber());
		if (product == null) {
			// throw exception
		}
		product = dtoMapper.toEntity(productDTO);
		productRepository.save(product);
		
		//update ShoppingCart
//		shoppingCartService.updateProductsInCarts(productDTO.getProductNumber(), productDTO.getName(), productDTO.getPrice());
	}
	
	private void reduceProductInStock(String productNumber, long quantity) {
		Product product = getProduct(productNumber);
		
		if (product.getStock() != null) {
			Stock stock = product.getStock();
			stock.setQuantity(stock.getQuantity() - quantity);
		}
		
		productRepository.save(product);
	}

	@Override
	public void reduceProductInStock(List<OrderedProductDTO> orderedProductDtos) {
		
		for(OrderedProductDTO orderedProductDto : orderedProductDtos) {
			reduceProductInStock(orderedProductDto.getProductNumber(), orderedProductDto.getQuantity());
		}
		
	}
}
