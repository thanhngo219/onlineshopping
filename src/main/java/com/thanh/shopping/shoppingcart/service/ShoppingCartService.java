package com.thanh.shopping.shoppingcart.service;

import com.thanh.shopping.shoppingcart.domain.ShoppingCart;
import com.thanh.shopping.shoppingcart.dto.ProductDTO;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;

public interface ShoppingCartService {
	
	void addToCart(String cartId, ProductDTO productDTO, Long quantity);
	
	ShoppingCartDTO getShoppingCartDTO(String cartId);
	
	void checkOut(String cartId);
	
	ShoppingCart getShoppingCart(String cartId);
	
	void updateProductsInCarts(String productNumber, String productName, Double price);
}
