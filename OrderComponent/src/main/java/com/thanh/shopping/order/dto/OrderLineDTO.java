package com.thanh.shopping.order.dto;

import com.thanh.shopping.dto.BaseDTO;

public class OrderLineDTO extends BaseDTO {

	private ProductDTO product;
	
	private Long quantity;
	
	public OrderLineDTO() {
	}

	public OrderLineDTO(ProductDTO product, Long quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
