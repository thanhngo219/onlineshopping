package com.thanh.shopping.customer.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.thanh.shopping.customer.domain.Account;
import com.thanh.shopping.customer.domain.Address;
import com.thanh.shopping.customer.domain.CreditCard;
import com.thanh.shopping.customer.domain.Customer;
import com.thanh.shopping.customer.dto.AccountDTO;
import com.thanh.shopping.customer.dto.AddressDTO;
import com.thanh.shopping.customer.dto.CreditCardDTO;
import com.thanh.shopping.customer.dto.CustomerDTO;
import com.thanh.shopping.mapper.DtoMapper;

@Component
@Qualifier("customerMapper")
public class CustomerMapper implements DtoMapper<Customer, CustomerDTO> {

	@Autowired
	@Qualifier("accountMapper")
	private DtoMapper<Account, AccountDTO> accountMapper;
	
	@Autowired
	@Qualifier("addressMapper")
	private DtoMapper<Address, AddressDTO> addressMapper;
	
	@Autowired
	@Qualifier("creditCardMapper")
	private DtoMapper<CreditCard, CreditCardDTO> creditCardMapper;
	
	@Override
	public CustomerDTO toDTO(Customer entity) {
		CustomerDTO customerDto = new CustomerDTO(entity.getCustomerNumber(), entity.getFirstName(),
				entity.getLastName(), entity.getEmail(), entity.getPhone());
		
		List<CreditCardDTO> creditCardDtos = new ArrayList<CreditCardDTO>();
		if (entity.getCreditCards() != null) {
			for (CreditCard creditCard : entity.getCreditCards()) {
				creditCardDtos.add(new CreditCardDTO(creditCard.getCardNumber(), creditCard.getExpirationDate()));
			}
		}
		customerDto.setCreditCards(creditCardDtos);
		
		AccountDTO accountDto = null;
		if (entity.getAccount() != null) {			
			accountDto = new AccountDTO(entity.getAccount().getAccountNumber(),
					entity.getAccount().getUsername(), entity.getAccount().getPassword());
		}
		customerDto.setAccount(accountDto);
		
		AddressDTO addressDto = null;
		Address address = entity.getAddress();
		if (address != null) {
			addressDto = new AddressDTO(address.getStreet(), address.getCity(), address.getZipCode(), address.getCountry());
		}
		customerDto.setAddress(addressDto);

		return customerDto;
	}

	@Override
	public Customer toEntity(CustomerDTO dto) {
		AddressDTO addressDto = dto.getAddress();
		Address address = null;
		if (addressDto != null) {
			address = addressMapper.toEntity(addressDto);
		}
		
		AccountDTO accountDto = dto.getAccount();
		Account account = null;
		if(accountDto != null) {
			account = accountMapper.toEntity(accountDto);
		}
		
		List<CreditCardDTO> creditCardDtos = dto.getCreditCards();
		List<CreditCard> creditCards = new ArrayList<>();
		if(creditCardDtos != null && !creditCardDtos.isEmpty()) {
			for(CreditCardDTO creditCardDto : creditCardDtos) {
				creditCards.add(creditCardMapper.toEntity(creditCardDto));
			}
		}
		
		Customer customer = new Customer(dto.getCustomerNumber(), dto.getFirstName(),
				dto.getLastName(), dto.getEmail(), dto.getPhone(), account, address, creditCards);
		return customer;
	}

}
