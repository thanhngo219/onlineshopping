package com.thanh.shopping.product.service;

import com.thanh.shopping.product.domain.Product;
import com.thanh.shopping.product.domain.Stock;

public interface ProductService {
	void addProduct(String productNumber, String name, String description, Double price);
	
	Product getProduct(String productNumber);
	
	void setStock(Long quantity, String locationCode, String productNumber);
}
