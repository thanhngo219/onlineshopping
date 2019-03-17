package com.thanh.shopping.customer.dto;

import com.thanh.shopping.dto.BaseDTO;

public class AddressDTO extends BaseDTO {

	private String street;
	
	private String city;
	
	private String zipCode;
	
	private String country;

	public AddressDTO(String street, String city, String zipCode, String country) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	public final String getStreet() {
		return street;
	}

	public final void setStreet(String street) {
		this.street = street;
	}

	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		this.city = city;
	}

	public final String getZipCode() {
		return zipCode;
	}

	public final void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public final String getCountry() {
		return country;
	}

	public final void setCountry(String country) {
		this.country = country;
	}
}
