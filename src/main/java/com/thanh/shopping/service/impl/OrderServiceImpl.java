package com.thanh.shopping.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanh.shopping.domain.order.Order;
import com.thanh.shopping.domain.order.OrderBuilder;
import com.thanh.shopping.domain.shoppingcart.ShoppingCart;
import com.thanh.shopping.repository.OrderRepository;
import com.thanh.shopping.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void createOrder(ShoppingCartDTO shoppingCart) {
		Order order = OrderBuilder.buildOrder(shoppingCart);
		orderRepository.save(order);
	}

	@Override
	public OrderDTO getOrder(String orderId) {
		Optional<Order> optOrder = orderRepository.findById(orderId);
		return optOrder.isPresent() ? optOrder.get() : null;
	}

}
