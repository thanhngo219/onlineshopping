package com.thanh.shopping.order.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.order.domain.Order;
import com.thanh.shopping.order.domain.OrderLine;
import com.thanh.shopping.order.dto.OrderDTO;
import com.thanh.shopping.order.dto.OrderLineDTO;

@Service
@Qualifier("orderMapper")
public class OrderMapper implements DtoMapper<Order, OrderDTO> {
	
	@Autowired
	@Qualifier("orderLineMapper")
	private DtoMapper<OrderLine, OrderLineDTO> dtoMapper;

	@Override
	public OrderDTO toDTO(Order order) {
		OrderDTO result = new OrderDTO(order.getOrderId(), order.getOrderDate(), order.getOrderStatus());
		for(OrderLine orderLine : order.getOrderLines()) {
			result.addToOrderLines(dtoMapper.toDTO(orderLine));
		}
		return result;
	}

	@Override
	public Order toEntity(OrderDTO v) {
		// TODO Auto-generated method stub
		return null;
	}

}
