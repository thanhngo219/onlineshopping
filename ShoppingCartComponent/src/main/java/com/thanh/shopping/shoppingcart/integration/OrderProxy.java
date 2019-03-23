package com.thanh.shopping.shoppingcart.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;

@Component
public class OrderProxy {
	
	@Autowired
	private RestOperations restTemplate;
	
	@Value("${order.root.url}")
	private String orderUrl;
	
	public void createOrder(ShoppingCartDTO shoppingCartDTO) {
		restTemplate.postForObject(orderUrl + "order", shoppingCartDTO, ShoppingCartDTO.class);
	}
}
