package com.thanh.shopping.product.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanh.shopping.product.domain.Product;
import com.thanh.shopping.product.domain.Stock;
import com.thanh.shopping.product.repository.ProductRepository;
import com.thanh.shopping.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(String productNumber, String name, String description, Double price) {
		Product product = new Product();
		product.setProductNumber(productNumber);
		product.setName(name);
		product.setPrice(price);
		product.setDescription(description);
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
}
