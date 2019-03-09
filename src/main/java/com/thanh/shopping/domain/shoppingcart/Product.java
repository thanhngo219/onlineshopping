package com.thanh.shopping.domain.shoppingcart;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class Product extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7047462199795721098L;
	
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
