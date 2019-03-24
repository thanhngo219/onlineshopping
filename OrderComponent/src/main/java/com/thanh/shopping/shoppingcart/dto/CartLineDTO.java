package com.thanh.shopping.shoppingcart.dto;

import com.thanh.shopping.dto.BaseDTO;

public class CartLineDTO extends BaseDTO {
	
	private ProductDTO product;
	
	private Long quantity;
	
	public CartLineDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartLineDTO(ProductDTO product, Long quantity) {
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
