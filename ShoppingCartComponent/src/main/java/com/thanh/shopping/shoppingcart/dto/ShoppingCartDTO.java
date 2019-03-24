package com.thanh.shopping.shoppingcart.dto;

import java.util.ArrayList;
import java.util.List;

import com.thanh.shopping.dto.BaseDTO;

public class ShoppingCartDTO extends BaseDTO {

	private String cartId;
	
	private List<CartLineDTO> cartLines = new ArrayList<CartLineDTO>();
	
	public ShoppingCartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoppingCartDTO(String cartId) {
		this.cartId = cartId;
	}

	public void addToCartLines(CartLineDTO cartLine) {
		cartLines.add(cartLine);
	}

	public final String getCartId() {
		return cartId;
	}

	public final void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public final List<CartLineDTO> getCartLines() {
		return cartLines;
	}

	public final void setCartLines(List<CartLineDTO> cartLines) {
		this.cartLines = cartLines;
	}
}
