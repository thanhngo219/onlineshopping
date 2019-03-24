package com.thanh.shopping.shoppingcart.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class ShoppingCart extends BaseEntity {

	@Id
	private String cartId;
	
	private List<ShoppingCartLine> cartLines = new ArrayList<ShoppingCartLine>();
	
	public void addToCart(String productNumber, String productName, Double price, Long quantity) {
		for (ShoppingCartLine cartLine : cartLines) {
			Product cartLineProduct = cartLine.getProduct();
			if (cartLineProduct.getProductNumber().equals(productName)) {
				cartLine.setQuantity(cartLine.getQuantity() + quantity);
				return;
			}
		}
		ShoppingCartLine cartLine = new ShoppingCartLine();
		Product p = new Product(productNumber, productName, price);
		cartLine.setProduct(p);
		cartLine.setQuantity(quantity);
		cartLines.add(cartLine);
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public List<ShoppingCartLine> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<ShoppingCartLine> cartLines) {
		this.cartLines = cartLines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((cartLines == null) ? 0 : cartLines.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (cartLines == null) {
			if (other.cartLines != null)
				return false;
		} else if (!cartLines.equals(other.cartLines))
			return false;
		return true;
	}
}
