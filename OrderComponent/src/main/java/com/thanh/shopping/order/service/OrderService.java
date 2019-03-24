package com.thanh.shopping.order.service;

import com.thanh.shopping.order.dto.OrderDTO;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;

public interface OrderService {
	
	void createOrder(ShoppingCartDTO shoppingCart);
	
	OrderDTO getOrder(String orderId);

	void confirm(String orderNumber);
	
	void setCustomer(String orderNumber, String customerNumber);
}
