package com.thanh.shopping.customer.dto;

import com.thanh.shopping.dto.BaseDTO;

public class AccountDTO extends BaseDTO {
	
	private String accountNumber;
	
	private String username;
	
	private String password;

	public AccountDTO(String accountNumber, String username, String password) {
		super();
		this.accountNumber = accountNumber;
		this.username = username;
		this.password = password;
	}

	public final String getAccountNumber() {
		return accountNumber;
	}

	public final void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}
}
