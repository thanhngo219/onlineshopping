package com.thanh.shopping.customer.dto;

import java.util.ArrayList;
import java.util.List;

import com.thanh.shopping.dto.BaseDTO;

public class CustomerDTO extends BaseDTO {
	private String customerNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private AddressDTO address;
	
	private AccountDTO account;
	
	private List<CreditCardDTO> creditCards = new ArrayList<>();

	public CustomerDTO(String customerNumber, String firstName, String lastName, String email, String phone,
			AddressDTO address, AccountDTO account, List<CreditCardDTO> creditCards) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.account = account;
		this.creditCards = creditCards;
	}

	public final String getCustomerNumber() {
		return customerNumber;
	}

	public final void setCustomerNumber(String customerNumber) {
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

	public final AddressDTO getAddress() {
		return address;
	}

	public final void setAddress(AddressDTO address) {
		this.address = address;
	}

	public final AccountDTO getAccount() {
		return account;
	}

	public final void setAccount(AccountDTO account) {
		this.account = account;
	}

	public final List<CreditCardDTO> getCreditCards() {
		return creditCards;
	}

	public final void setCreditCards(List<CreditCardDTO> creditCards) {
		this.creditCards = creditCards;
	}
}
