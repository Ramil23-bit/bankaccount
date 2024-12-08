package org.example.bankaccount.service;

import org.example.bankaccount.entity.Account;
import org.example.bankaccount.entity.UserBank;
import org.example.bankaccount.exception.AccountNotFoundException;
import org.example.bankaccount.repository.AccountJpaRepository;
import org.example.bankaccount.repository.UserBankJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public Account getById(Long id) {
        return accountJpa.findById(id)
                .orElseThrow(()-> new AccountNotFoundException("Account with id " + id + " not found"));
    }

    @Override
    public Account create(Account account) {
        return accountJpa.save(account);
    }

    @Override
    public void delete(Long id) {
        accountJpa.deleteById(id);
    }

    @Override
    public String getCurrentUserBankName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            return authentication.getName();
        }
        return null;
    }

    @Override
    public Account saveForUserBank(Long id) {
        return null;
    }


}
