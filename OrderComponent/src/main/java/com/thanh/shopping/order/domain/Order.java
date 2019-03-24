package com.thanh.shopping.order.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class Order extends BaseEntity {

	@Id
	private String orderId;
	
	private Date orderDate;
	
	private String orderStatus;
	
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	private Customer customer;
	
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public void confirm() {
		this.orderStatus = "confirmed";		
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
