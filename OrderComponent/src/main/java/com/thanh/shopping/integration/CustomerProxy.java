package com.thanh.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.thanh.shopping.order.dto.OrderCustomerDTO;

@Component
public class CustomerProxy {
	
	@Autowired
	private RestOperations restTemplate;
	
	@Value("${customer.url}")
	String customersURL;
	
	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		OrderCustomerDTO customer = restTemplate.getForObject(customersURL + "/orderCustomer/" + customerNumber, OrderCustomerDTO.class);
		return customer;
	};
}
