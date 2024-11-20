package org.example.bankaccount.service;

import org.example.bankaccount.entity.Account;
import org.example.bankaccount.repository.AccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements  AccountService{
    @Autowired
    private AccountJpaRepository accountJpa;
    @Override
    public List<Account> getAll() {
        return accountJpa.findAll();
    }

    @Override
    public Optional<Account> getById(Long id) {
        return accountJpa.findById(id);
    }

    @Override
    public Account create(Account account) {
        return accountJpa.save(account);
    }

    @Override
    public void delete(Long id) {
        accountJpa.deleteById(id);
    }
}
