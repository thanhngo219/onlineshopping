package com.thanh.shopping.customer.domain;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.thanh.shopping.domain.BaseEntity;

@Document
public class CreditCard extends BaseEntity {
	
	private String cardNumber;
	
	private LocalDate expirationDate;

	public CreditCard(String cardNumber, LocalDate expirationDate) {
		super();
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}

	public final String getCardNumber() {
		return cardNumber;
	}

	public final LocalDate getExpirationDate() {
		return expirationDate;
	}
}
