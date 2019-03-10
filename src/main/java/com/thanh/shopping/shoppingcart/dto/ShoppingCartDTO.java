package com.thanh.shopping.shoppingcart.dto;

import java.util.ArrayList;
import java.util.List;

import com.thanh.shopping.order.dto.BaseDTO;

public class ShoppingCartDTO extends BaseDTO {

	private String cartId;
	
	private List<CartLineDTO> cartLines = new ArrayList<CartLineDTO>();
	
	public ShoppingCartDTO(String cartId) {
		super();
		this.cartId = cartId;
	}

	public void addToCartLines(CartLineDTO cartLine) {
		cartLines.add(cartLine);
	}

	public String getCartId() {
		return cartId;
	}

	public List<CartLineDTO> getCartLines() {
		return cartLines;
	}
}
