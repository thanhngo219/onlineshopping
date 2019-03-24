package com.thanh.shopping.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.thanh.shopping.order.dto.OrderedProductDTO;

@Component
public class JmsSender {
	
	@Autowired
	JmsTemplate jmsTemplate;

	public void sendJMSMessage(List<OrderedProductDTO> orderedProductDtos) {
		System.out.println("Sending a JMS message.");
		jmsTemplate.convertAndSend("Ordered Products", orderedProductDtos);
	}
}
