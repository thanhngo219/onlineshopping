package com.thanh.shopping.customer.service;

import com.thanh.shopping.customer.dto.CustomerDTO;
import com.thanh.shopping.customer.dto.OrderCustomerDTO;


public interface CustomerService {

	public void addCustomer(CustomerDTO customerDto);
	
	public CustomerDTO getCustomer(String customerNumber);
	
	public OrderCustomerDTO getOrderCustomer(String customerNumber);
}
