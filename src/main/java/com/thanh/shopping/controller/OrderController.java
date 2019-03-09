package com.thanh.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thanh.shopping.converter.DtoConverter;
import com.thanh.shopping.domain.order.Order;
import com.thanh.shopping.dto.OrderDTO;
import com.thanh.shopping.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "order/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrder(@PathVariable("orderId") String orderId) {
		Order order = orderService.getOrder(orderId);
		OrderDTO result = DtoConverter.orderToDTO(order);
		return new ResponseEntity<OrderDTO>(result, HttpStatus.OK);
	}
}
