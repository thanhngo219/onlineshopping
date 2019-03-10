package com.thanh.shopping.product.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.product.domain.Product;
import com.thanh.shopping.product.domain.Stock;
import com.thanh.shopping.product.dto.ProductDTO;
import com.thanh.shopping.product.repository.ProductRepository;
import com.thanh.shopping.product.service.ProductService;
import com.thanh.shopping.shoppingcart.service.ShoppingCartService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
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
		shoppingCartService.updateProductsInCarts(productDTO.getProductNumber(), productDTO.getName(), productDTO.getPrice());
	}
}
