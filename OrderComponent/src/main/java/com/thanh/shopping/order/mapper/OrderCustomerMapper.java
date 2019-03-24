package com.thanh.shopping.order.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.order.domain.Address;
import com.thanh.shopping.order.domain.Customer;
import com.thanh.shopping.order.dto.OrderCustomerDTO;

@Service
@Qualifier("orderCustomerMapper")
public class OrderCustomerMapper implements DtoMapper<Customer, OrderCustomerDTO> {

	@Override
	public OrderCustomerDTO toDTO(Customer entity) {
		OrderCustomerDTO customer = new OrderCustomerDTO(entity.getCustomerNumber(), entity.getFirstName(),
				entity.getLastName(), entity.getEmail(), entity.getPhone());
		return customer;
	}

	@Override
	public Customer toEntity(OrderCustomerDTO dto) {
		Customer customer = new Customer(dto.getCustomerNumber(), dto.getFirstname(), dto.getLastname(), dto.getEmail(), dto.getPhone(),
				new Address(dto.getStreet(), dto.getCity(), dto.getZip(), dto.getCountry()));
		return customer;
	}

}
