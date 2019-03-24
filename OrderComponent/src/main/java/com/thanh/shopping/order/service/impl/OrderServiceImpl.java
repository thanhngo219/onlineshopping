package com.thanh.shopping.order.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.integration.CustomerProxy;
import com.thanh.shopping.integration.EmailSender;
import com.thanh.shopping.integration.JmsSender;
import com.thanh.shopping.integration.Logger;
import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.order.domain.Customer;
import com.thanh.shopping.order.domain.Order;
import com.thanh.shopping.order.domain.OrderBuilder;
import com.thanh.shopping.order.domain.OrderLine;
import com.thanh.shopping.order.dto.OrderCustomerDTO;
import com.thanh.shopping.order.dto.OrderDTO;
import com.thanh.shopping.order.dto.OrderedProductDTO;
import com.thanh.shopping.order.repository.OrderRepository;
import com.thanh.shopping.order.service.OrderService;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	@Qualifier("orderMapper")
	private DtoMapper<Order, OrderDTO> orderMapper;
	
	@Autowired
	@Qualifier("orderCustomerMapper")
	private DtoMapper<Customer, OrderCustomerDTO> orderCustomerMapper;
	
	@Autowired
	@Qualifier("orderedProductMapper")
	private DtoMapper<OrderLine, OrderedProductDTO> orderedProductMapper;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private Logger logger;
	
	@Autowired
	private CustomerProxy customerProxy;
	
	@Autowired
	private JmsSender jmsSender;
	
	@Override
	public void createOrder(ShoppingCartDTO shoppingCart) {
		Order order = OrderBuilder.buildOrder(shoppingCart);
		orderRepository.save(order);
	}

	@Override
	public OrderDTO getOrder(String orderId) {
		Optional<Order> optOrder = orderRepository.findById(orderId);
		return optOrder.isPresent() ? orderMapper.toDTO(optOrder.get()) : null;
	}

	public void confirm(String orderNumber) {
		Optional<Order> optOrder = orderRepository.findById(orderNumber);
		if (optOrder.isPresent()) {
			Order order= optOrder.get();
			order.confirm();
			emailSender.sendEmail("Thank you for your order with order number " + order.getOrderId(), "customer@gmail.com");
			logger.log("new order with order number " + order.getOrderId());
			List<OrderedProductDTO> orderProducts = new ArrayList<OrderedProductDTO>();
			for (OrderLine orderLine : order.getOrderLines()) {
				OrderedProductDTO orderedProduct = orderedProductMapper.toDTO(orderLine);
				orderProducts.add(orderedProduct);
			}
			
			if (orderProducts != null && !orderProducts.isEmpty()) {
				jmsSender.sendJMSMessage(orderProducts);
			}
			
		} 
	}

	@Override
	public void setCustomer(String orderNumber, String customerNumber) {
		Optional<Order> optOrder = orderRepository.findById(orderNumber);
		if (optOrder.isPresent()) {
			Order order = optOrder.get();
			OrderCustomerDTO customerDTO = customerProxy.getOrderCustomer(customerNumber);
			if(customerDTO!=null) {
				order.setCustomer(orderCustomerMapper.toEntity(customerDTO));
			}
			orderRepository.save(order);
		}		
	}
}
