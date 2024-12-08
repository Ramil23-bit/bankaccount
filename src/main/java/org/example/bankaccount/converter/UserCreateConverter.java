package org.example.bankaccount.converter;

import org.example.bankaccount.dto.UserBankCreateDto;
import org.example.bankaccount.dto.UserBankResponseDto;
import org.example.bankaccount.entity.UserBank;
import org.springframework.stereotype.Component;

@Component
public class UserCreateConverter implements Converter<UserBank, UserBankCreateDto, UserBankResponseDto> {
    @Override
    public UserBankResponseDto toDto(UserBank userBank) {
        return new UserBankResponseDto(userBank.getId(), userBank.getLogin(), userBank.getEmail(), userBank.getAccountList());
    }

    @Override
    public UserBank toEntity(UserBankCreateDto userBankCreateDto) {
        return new UserBank(userBankCreateDto.getLogin(), userBankCreateDto.getPassword(), userBankCreateDto.getEmail());
    }
}
