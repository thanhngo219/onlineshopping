package com.thanh.shopping.customer.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.thanh.shopping.customer.domain.Customer;
import com.thanh.shopping.customer.dto.OrderCustomerDTO;
import com.thanh.shopping.mapper.DtoMapper;

@Component
@Qualifier("orderCustomerMapper")
public class OrderCustomerMapper implements DtoMapper<Customer, OrderCustomerDTO> {

	@Override
	public OrderCustomerDTO toDTO(Customer entity) {
		OrderCustomerDTO customerDTO = new OrderCustomerDTO(
				entity.getCustomerNumber(),
				entity.getFirstName(),
				entity.getLastName(),
				entity.getEmail(),
				entity.getPhone()				
				);
		if (entity.getAddress() != null) {
			customerDTO.setStreet(entity.getAddress().getStreet());
			customerDTO.setCity(entity.getAddress().getCity());
			customerDTO.setZip(entity.getAddress().getZipCode());
			customerDTO.setCountry(entity.getAddress().getCountry());
		}

		return customerDTO;
	}

	@Override
	public Customer toEntity(OrderCustomerDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
