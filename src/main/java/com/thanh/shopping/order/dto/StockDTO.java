package com.thanh.shopping.order.dto;

public class StockDTO extends BaseDTO {
	
	private String locationCode;

	private Long quantity;
	
	public StockDTO(String locationCode, Long quantity) {
		super();
		this.locationCode = locationCode;
		this.quantity = quantity;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
