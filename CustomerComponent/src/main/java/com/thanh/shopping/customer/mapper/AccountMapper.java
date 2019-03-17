package com.thanh.shopping.customer.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.thanh.shopping.customer.domain.Account;
import com.thanh.shopping.customer.dto.AccountDTO;
import com.thanh.shopping.mapper.DtoMapper;

@Component
@Qualifier("accountMapper")
public class AccountMapper implements DtoMapper<Account, AccountDTO> {

	@Override
	public AccountDTO toDTO(Account entity) {
		return new AccountDTO(entity.getAccountNumber(), entity.getUsername(), entity.getPassword());
	}

	@Override
	public Account toEntity(AccountDTO dto) {
		return new Account(dto.getAccountNumber(), dto.getUsername(), dto.getPassword());
	}
}
