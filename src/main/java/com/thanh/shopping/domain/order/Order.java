package com.thanh.shopping.domain.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class Order extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 5288965284105202021L;

	@Id
	private String orderId;
	
	private Date orderDate;
	
	private String orderStatus;
	
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();
	
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
}
