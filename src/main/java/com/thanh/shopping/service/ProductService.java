package com.thanh.shopping.service;

import com.thanh.shopping.domain.product.Product;
import com.thanh.shopping.domain.product.Stock;

public interface ProductService {
	void addProduct(String productNumber, String name, String description, Double price);
	
	Product getProduct(String productNumber);
	
	void setStock(Long quantity, String locationCode, String productNumber);
}
