package org.example.bankaccount.converter;

import org.example.bankaccount.dto.UserBankChangeRoleDto;
import org.example.bankaccount.dto.UserBankCreateDto;

import org.example.bankaccount.entity.UserBank;
import org.springframework.stereotype.Component;

@Component
public class UserChangeConverter implements Converter<UserBank, UserBankCreateDto,UserBankChangeRoleDto>{
    @Override
    public UserBankChangeRoleDto toDto(UserBank userBank) {
        return new UserBankChangeRoleDto(userBank.getId(), userBank.getLogin(), userBank.getRole());
    }

    @Override
    public UserBank toEntity(UserBankCreateDto userBankCreateDto) {
        return new UserBank(userBankCreateDto.getName(), userBankCreateDto.getLogin(), userBankCreateDto.getPassword()
                ,userBankCreateDto.getEmail(), userBankCreateDto.getAccountList());
    }
}
