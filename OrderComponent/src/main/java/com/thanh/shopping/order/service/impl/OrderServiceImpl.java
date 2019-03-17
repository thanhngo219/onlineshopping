package com.thanh.shopping.order.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.order.domain.Order;
import com.thanh.shopping.order.domain.OrderBuilder;
import com.thanh.shopping.order.dto.OrderDTO;
import com.thanh.shopping.order.repository.OrderRepository;
import com.thanh.shopping.order.service.OrderService;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	@Qualifier("orderMapper")
	private DtoMapper<Order, OrderDTO> dtoMapper;
	
	@Override
	public void createOrder(ShoppingCartDTO shoppingCart) {
//		Order order = OrderBuilder.buildOrder(shoppingCart);
//		orderRepository.save(order);
	}

	@Override
	public OrderDTO getOrder(String orderId) {
		Optional<Order> optOrder = orderRepository.findById(orderId);
		return optOrder.isPresent() ? dtoMapper.toDTO(optOrder.get()) : null;
	}

}
