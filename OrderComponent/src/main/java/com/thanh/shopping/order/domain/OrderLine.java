package com.thanh.shopping.order.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class OrderLine extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -512628271496426970L;

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
