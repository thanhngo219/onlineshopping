package com.thanh.shopping.order.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class OrderLine extends BaseEntity {

	private Long quantity;
	
	private Product product;

	public OrderLine(Long quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}
}
