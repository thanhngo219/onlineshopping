package com.thanh.shopping.dto;

public class OrderLineDTO extends BaseDTO {
	private String productNumber;
	
	private Long quantity;
	
	public OrderLineDTO(String productNumber, Long quantity) {
		super();
		this.productNumber = productNumber;
		this.quantity = quantity;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public Long getQuantity() {
		return quantity;
	}
}
