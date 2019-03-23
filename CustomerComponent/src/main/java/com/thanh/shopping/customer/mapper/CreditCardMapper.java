package com.thanh.shopping.customer.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.thanh.shopping.customer.domain.CreditCard;
import com.thanh.shopping.customer.dto.CreditCardDTO;
import com.thanh.shopping.mapper.DtoMapper;

@Component
@Qualifier("creditCardMapper")
public class CreditCardMapper implements DtoMapper<CreditCard, CreditCardDTO> {

	@Override
	public CreditCardDTO toDTO(CreditCard entity) {
		return new CreditCardDTO(entity.getCardNumber(), entity.getExpirationDate());
	}

	@Override
	public CreditCard toEntity(CreditCardDTO dto) {
		return new CreditCard(dto.getCardNumber(), dto.getExpirationDate());
	}
}
