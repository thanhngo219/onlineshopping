package com.thanh.shopping.service;

import com.thanh.shopping.dto.OrderDTO;
import com.thanh.shopping.dto.ShoppingCartDTO;

public interface OrderService {
	
	void createOrder(ShoppingCartDTO shoppingCart);
	
	OrderDTO getOrder(String orderId);

}
