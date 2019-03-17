package com.thanh.shopping.order.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.order.domain.OrderLine;
import com.thanh.shopping.order.domain.Product;
import com.thanh.shopping.order.dto.OrderLineDTO;
import com.thanh.shopping.order.dto.ProductDTO;

@Service
@Qualifier("orderLineMapper")
public class OrderLineMapper implements DtoMapper<OrderLine, OrderLineDTO> {

	@Autowired
	@Qualifier("orderedProductMapper")
	private DtoMapper<Product, ProductDTO> dtoMapper;

	@Override
	public OrderLineDTO toDTO(OrderLine orderLine) {
		return new OrderLineDTO(dtoMapper.toDTO(orderLine.getProduct()), orderLine.getQuantity());
	}

	@Override
	public OrderLine toEntity(OrderLineDTO v) {
		// TODO Auto-generated method stub
		return null;
	}

}
