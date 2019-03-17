package com.thanh.shopping.customer.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class Customer extends BaseEntity {
	
	@Id
	private Long customerNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private Account account;

	private Address address;
	
	private List<CreditCard> creditCards = new ArrayList<>();

	public Customer(Long customerNumber, String firstName, String lastName, String email, String phone, Account account,
			Address address, List<CreditCard> creditCards) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.account = account;
		this.address = address;
		this.creditCards = creditCards;
	}

	public final Long getCustomerNumber() {
		return customerNumber;
	}

	public final void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final Account getAccount() {
		return account;
	}

	public final void setAccount(Account account) {
		this.account = account;
	}

	public final Address getAddress() {
		return address;
	}

	public final void setAddress(Address address) {
		this.address = address;
	}

	public final List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public final void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
}
