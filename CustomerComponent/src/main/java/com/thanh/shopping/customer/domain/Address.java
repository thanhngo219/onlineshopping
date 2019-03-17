package com.thanh.shopping.customer.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class Address extends BaseEntity {

	private String street;
	
	private String city;
	
	private String zipCode;
	
	private String country;

	public Address(String street, String city, String zipCode, String country) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCountry() {
		return country;
	}
}
