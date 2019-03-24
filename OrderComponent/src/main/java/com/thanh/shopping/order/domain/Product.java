package com.thanh.shopping.order.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class Product extends BaseEntity {

	private String productNumber;
	
	private String name;
	
	private Double price;

	public Product(String productNumber, String name, Double price) {
		super();
		this.productNumber = productNumber;
		this.name = name;
		this.price = price;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
}
