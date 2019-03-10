package com.thanh.shopping.shoppingcart.service;

import com.thanh.shopping.shoppingcart.domain.ShoppingCart;

public interface ShoppingCartService {
	
	void addToCart(String cartId, String productNumber, Long quantity);
	
	ShoppingCart getCart(String cartId);
	
	void checkOut(String cartId);
}
