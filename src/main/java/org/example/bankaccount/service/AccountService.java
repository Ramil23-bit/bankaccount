package org.example.bankaccount.service;

import org.apache.catalina.User;
import org.example.bankaccount.entity.Account;
import org.example.bankaccount.entity.UserBank;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAll();

    Account getById(Long id);

    Account create(Account account);

    void delete(Long id);

    String getCurrentUserBankName();

    Account saveForUserBank(Long id);
}
