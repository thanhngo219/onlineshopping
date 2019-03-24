package com.thanh.shopping.order.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.order.domain.Order;
import com.thanh.shopping.order.domain.OrderLine;
import com.thanh.shopping.order.dto.OrderedProductDTO;

@Component
@Qualifier("orderedProductMapper")
public class OrderProductMapper implements DtoMapper<OrderLine, OrderedProductDTO> {

	@Override
	public OrderedProductDTO toDTO(OrderLine entity) {
		OrderedProductDTO productDTO = new OrderedProductDTO();
		productDTO.setProductNumber(entity.getProduct().getProductNumber());
		productDTO.setQuantity(entity.getQuantity());
		return productDTO;
	}

	@Override
	public OrderLine toEntity(OrderedProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
