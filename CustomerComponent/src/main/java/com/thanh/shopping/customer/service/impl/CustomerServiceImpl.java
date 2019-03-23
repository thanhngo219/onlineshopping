package com.thanh.shopping.customer.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.customer.domain.Customer;
import com.thanh.shopping.customer.dto.CustomerDTO;
import com.thanh.shopping.customer.dto.OrderCustomerDTO;
import com.thanh.shopping.customer.repository.CustomerRepository;
import com.thanh.shopping.customer.service.CustomerService;
import com.thanh.shopping.mapper.DtoMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	@Qualifier("customerMapper")
	private DtoMapper<Customer, CustomerDTO> customerMapper;
	
	@Autowired
	@Qualifier("orderCustomerMapper")
	private DtoMapper<Customer, OrderCustomerDTO> orderCustomerMapper;
	
	@Override
	public void addCustomer(CustomerDTO customerDto) {
		customerRepository.save(customerMapper.toEntity(customerDto));
	}

	@Override
	public CustomerDTO getCustomer(String customerNumber) {
		Optional<Customer> optCustomer = customerRepository.findById(customerNumber);
		return optCustomer.isPresent() ? customerMapper.toDTO(optCustomer.get()) : null;
	}

	@Override
	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		  Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
		  if (customerOptional.isPresent()) {
			  Customer customer = customerOptional.get();
			  return orderCustomerMapper.toDTO(customer);
		  }
		  else
			  return null;
	}

}
