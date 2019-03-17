package com.thanh.shopping.shoppingcart.dto;

import com.thanh.shopping.dto.BaseDTO;

public class ProductDTO extends BaseDTO {
	
	private String productNumber;
	
	private String name;
	
	private Double price;

	public ProductDTO(String productNumber, String name, Double price) {
		super();
		this.productNumber = productNumber;
		this.name = name;
		this.price = price;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
