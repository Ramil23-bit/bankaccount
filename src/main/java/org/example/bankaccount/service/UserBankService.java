package org.example.bankaccount.service;

import jakarta.persistence.Id;
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

    UserBank changeUserBankRole(UserBank userBank);

    UserBank changeUserBankRoleById(Long id);


//    UserBank saveUserBankWithAccount(UserBank userBank);
}
