package com.thanh.shopping.customer.dto;

import java.time.LocalDate;

import com.thanh.shopping.dto.BaseDTO;

public class CreditCardDTO extends BaseDTO {

	private String cardNumber;
	
	private LocalDate expirationDate;

	public CreditCardDTO(String cardNumber, LocalDate expirationDate) {
		super();
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}

	public final String getCardNumber() {
		return cardNumber;
	}

	public final void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public final LocalDate getExpirationDate() {
		return expirationDate;
	}

	public final void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
