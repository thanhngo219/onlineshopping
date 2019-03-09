package com.thanh.shopping.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanh.shopping.domain.product.Product;
import com.thanh.shopping.domain.shoppingcart.ShoppingCart;
import com.thanh.shopping.repository.ShoppingCartRepository;
import com.thanh.shopping.service.OrderService;
import com.thanh.shopping.service.ProductService;
import com.thanh.shopping.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public void addToCart(String cartId, String productNumber, Long quantity) {
		Product product = productService.getProduct(productNumber);
		ShoppingCart cart = getCart(cartId);
		if (cart != null && product != null) {
			cart.addToCart(product.getProductNumber(), product.getName(), product.getPrice(), quantity);
		}
		else if (product != null) {
			cart = new ShoppingCart();
			cart.setCartId(cartId);
			cart.addToCart(product.getProductNumber(), product.getName(), product.getPrice(), quantity);
		}
		shoppingCartRepository.save(cart);
	}

	@Override
	public ShoppingCart getCart(String cartId) {
		Optional<ShoppingCart> optCart = shoppingCartRepository.findById(cartId);
		if (optCart.isPresent()) {
			return optCart.get();
		}
		return null;
	}

	@Override
	public void checkOut(String cartId) {
		ShoppingCart shoppingCart = getCart(cartId);
		if (shoppingCart != null) {
			orderService.createOrder(shoppingCart);
		}
	}
}
