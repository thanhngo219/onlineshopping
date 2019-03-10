package com.thanh.shopping.order.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanh.shopping.order.domain.Order;
import com.thanh.shopping.order.domain.OrderBuilder;
import com.thanh.shopping.order.repository.OrderRepository;
import com.thanh.shopping.order.service.OrderService;
import com.thanh.shopping.shoppingcart.domain.ShoppingCart;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void createOrder(ShoppingCart shoppingCart) {
		Order order = OrderBuilder.buildOrder(shoppingCart);
		orderRepository.save(order);
	}

	@Override
	public Order getOrder(String orderId) {
		Optional<Order> optOrder = orderRepository.findById(orderId);
		return optOrder.isPresent() ? optOrder.get() : null;
	}

}
