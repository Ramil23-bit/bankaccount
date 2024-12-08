package org.example.bankaccount.service;

import org.example.bankaccount.entity.UserBank;

import java.util.List;
import java.util.Optional;

public interface UserBankService {

    List<UserBank> getAll();

    UserBank getById(Long id);

    UserBank create(UserBank userBank);

    void deleteById(Long id);

    UserBank getByName(String name);

    Long getCurrentId();

//    UserBank saveUserBankWithAccount(UserBank userBank);
}
