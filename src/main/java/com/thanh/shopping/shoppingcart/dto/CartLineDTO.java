package com.thanh.shopping.shoppingcart.dto;

import com.thanh.shopping.order.dto.BaseDTO;

public class CartLineDTO extends BaseDTO {
	private String productNumber;
	
	private Long quantity;
	
	public CartLineDTO(String productNumber, Long quantity) {
		super();
		this.productNumber = productNumber;
		this.quantity = quantity;
	}

	public String getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
