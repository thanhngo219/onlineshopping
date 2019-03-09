package com.thanh.shopping.service;

import com.thanh.shopping.domain.shoppingcart.ShoppingCart;

public interface ShoppingCartService {
	
	void addToCart(String cartId, String productNumber, Long quantity);
	
	ShoppingCart getCart(String cartId);
	
	void checkOut(String cartId);
}
