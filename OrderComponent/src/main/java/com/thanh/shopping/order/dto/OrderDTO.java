package com.thanh.shopping.order.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thanh.shopping.dto.BaseDTO;

public class OrderDTO extends BaseDTO {
	private String orderId;

	private Date orderDate;

	private String orderStatus;
	
	private List<OrderLineDTO> orderLines = new ArrayList<OrderLineDTO>();
	
	private OrderCustomerDTO customer;
	
	public OrderDTO() {
	}

	public OrderDTO(String orderId, Date orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	
	public void addToOrderLines(OrderLineDTO orderLine) {
		orderLines.add(orderLine);
	}

	public final String getOrderId() {
		return orderId;
	}

	public final void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public final Date getOrderDate() {
		return orderDate;
	}

	public final void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public final String getOrderStatus() {
		return orderStatus;
	}

	public final void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public final List<OrderLineDTO> getOrderLines() {
		return orderLines;
	}

	public final void setOrderLines(List<OrderLineDTO> orderLines) {
		this.orderLines = orderLines;
	}

	public final OrderCustomerDTO getCustomer() {
		return customer;
	}

	public final void setCustomer(OrderCustomerDTO customer) {
		this.customer = customer;
	}
	
}
