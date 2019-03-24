package com.thanh.shopping.product.dto;

import com.thanh.shopping.dto.BaseDTO;

public class OrderedProductDTO extends BaseDTO {
	private String productNumber;
	
	private Long quantity;

	public final String getProductNumber() {
		return productNumber;
	}

	public final void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public final Long getQuantity() {
		return quantity;
	}

	public final void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
}
