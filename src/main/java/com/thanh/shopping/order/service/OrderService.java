package com.thanh.shopping.order.service;

import com.thanh.shopping.order.domain.Order;
import com.thanh.shopping.order.dto.OrderDTO;
import com.thanh.shopping.shoppingcart.domain.ShoppingCart;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;

public interface OrderService {
	
	void createOrder(ShoppingCart shoppingCart);
	
	Order getOrder(String orderId);

}
