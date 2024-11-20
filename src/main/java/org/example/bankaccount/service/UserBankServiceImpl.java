package org.example.bankaccount.service;

import org.example.bankaccount.entity.UserBank;
import org.example.bankaccount.repository.UserBankJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserBankServiceImpl implements UserBankService {

    @Autowired
    private UserBankJpaRepository userBankJpa;

    @Override
    public List<UserBank> getAll() {
        return userBankJpa.findAll();
    }

    @Override
    public Optional<UserBank> getById(Long id) {
        return userBankJpa.findById(id);
    }

    @Override
    public UserBank create(UserBank userBank) {
        return userBankJpa.save(userBank);
    }

    @Override
    public void delete(Long id) {
        userBankJpa.deleteById(id);
    }
}
