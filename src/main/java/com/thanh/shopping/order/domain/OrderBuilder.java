package com.thanh.shopping.order.domain;

import java.util.Calendar;

import com.thanh.shopping.shoppingcart.domain.ShoppingCart;
import com.thanh.shopping.shoppingcart.domain.ShoppingCartLine;

public class OrderBuilder {
	public static Order buildOrder(ShoppingCart shoppingCart) {
		Order order = new Order();
		order.setOrderId(shoppingCart.getCartId());
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderStatus("Ordered");
		for(ShoppingCartLine cartLine : shoppingCart.getCartLines()) {
			com.thanh.shopping.shoppingcart.domain.Product shoppingCartProduct = cartLine.getProduct();
			Product product = new Product(shoppingCartProduct.getProductNumber(),
					shoppingCartProduct.getName(), shoppingCartProduct.getPrice());
			OrderLine orderLine = new OrderLine(cartLine.getQuantity(), product);
			order.addOrderLine(orderLine);
		}
		return order;
	}
}
