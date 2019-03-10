package com.thanh.shopping.order.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO extends BaseDTO {
	private String orderId;

	private Date orderDate;

	private String orderStatus;
	
	private List<OrderLineDTO> orderLines = new ArrayList<OrderLineDTO>();
	
	public OrderDTO(String orderId, Date orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	
	public void addToOrderLines(OrderLineDTO orderLine) {
		orderLines.add(orderLine);
	}

	public String getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public List<OrderLineDTO> getOrderLines() {
		return orderLines;
	}
}
