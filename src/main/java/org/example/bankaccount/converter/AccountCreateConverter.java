package org.example.bankaccount.converter;

import org.example.bankaccount.dto.AccountCreateDto;
import org.example.bankaccount.dto.AccountResponseDto;
import org.example.bankaccount.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountCreateConverter implements Converter<Account, AccountCreateDto, AccountResponseDto> {


    @Override
    public AccountResponseDto toDto(Account account) {
        return new AccountResponseDto(account.getId(), account.getAmount());
    }

    @Override
    public Account toEntity(AccountCreateDto accountCreateDto) {
        return new Account(accountCreateDto.getId(), accountCreateDto.getAmount(),accountCreateDto.getCurrencyType());
    }
}
