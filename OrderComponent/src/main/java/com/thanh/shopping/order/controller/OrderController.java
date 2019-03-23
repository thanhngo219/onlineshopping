package com.thanh.shopping.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thanh.shopping.order.dto.OrderDTO;
import com.thanh.shopping.order.service.OrderService;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "order/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrder(@PathVariable("orderId") String orderId) {
		OrderDTO order = orderService.getOrder(orderId);
		return new ResponseEntity<OrderDTO>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ResponseEntity<?> createOrder(ShoppingCartDTO shoppingCartDTO) {
		orderService.createOrder(shoppingCartDTO);
		return new ResponseEntity<OrderDTO>(HttpStatus.OK);
	}
}
