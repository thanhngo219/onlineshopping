package com.thanh.shopping.order.domain;

import java.util.Calendar;

import com.thanh.shopping.shoppingcart.dto.CartLineDTO;
import com.thanh.shopping.shoppingcart.dto.ProductDTO;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;

public class OrderBuilder {
	public static Order buildOrder(ShoppingCartDTO shoppingCart) {
		Order order = new Order();
		order.setOrderId(shoppingCart.getCartId());
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderStatus("Ordered");
		for(CartLineDTO cartLine : shoppingCart.getCartLines()) {
			ProductDTO shoppingCartProduct = cartLine.getProduct();
			Product product = new Product(shoppingCartProduct.getProductNumber(),
					shoppingCartProduct.getName(), shoppingCartProduct.getPrice());
			OrderLine orderLine = new OrderLine(cartLine.getQuantity(), product);
			order.addOrderLine(orderLine);
		}
		return order;
	}
}
