package com.thanh.shopping.customer.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.thanh.shopping.customer.domain.Address;
import com.thanh.shopping.customer.dto.AddressDTO;
import com.thanh.shopping.mapper.DtoMapper;

@Component
@Qualifier("addressMapper")
public class AddressMapper implements DtoMapper<Address, AddressDTO> {

	@Override
	public AddressDTO toDTO(Address entity) {
		return new AddressDTO(entity.getStreet(), entity.getCity(), entity.getZipCode(), entity.getCountry());
	}

	@Override
	public Address toEntity(AddressDTO dto) {
		return new Address(dto.getStreet(), dto.getCity(), dto.getZipCode(), dto.getCountry());
	}

}
