package com.thanh.shopping.product.dto;

import com.thanh.shopping.dto.BaseDTO;

public class ProductDTO extends BaseDTO {
	private String productNumber;
	
	private String name;
	
	private Double price;
	
	private String description;
	
	private StockDTO stock;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StockDTO getStock() {
		return stock;
	}

	public void setStock(StockDTO stock) {
		this.stock = stock;
	}
	
}
