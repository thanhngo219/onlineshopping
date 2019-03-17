package com.thanh.shopping.customer.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class Account extends BaseEntity {
	
	@Id
	private String accountNumber;
	
	private String username;
	
	private String password;
	
	public Account(String accountNumber, String username, String password) {
		super();
		this.accountNumber = accountNumber;
		this.username = username;
		this.password = password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
