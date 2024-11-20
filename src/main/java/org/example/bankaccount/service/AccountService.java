package org.example.bankaccount.service;

import org.example.bankaccount.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAll();

    Optional<Account> getById(Long id);

    Account create(Account account);

    void delete(Long id);
}
