package org.example.bankaccount.service;

import org.example.bankaccount.entity.Account;
import org.example.bankaccount.entity.UserBank;
import org.example.bankaccount.enums.Role;
import org.example.bankaccount.exception.UserNotFoundException;
import org.example.bankaccount.repository.UserBankJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public UserBank getById(Long id) {
        return userBankJpa.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public UserBank create(UserBank userBank) {
        return userBankJpa.save(userBank);
    }

    @Override
    public void deleteById(Long id) {
        userBankJpa.deleteById(id);
    }

    @Override
    public UserBank getByName(String name) {
        return userBankJpa.findUserBankByLogin(name);
    }

    @Override
    public Long getCurrentId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            String name = authentication.getName();
            UserBank userBank = getByName(name);
            return userBank.getId();
        }
        return null;
    }
    @Override
    public UserBank changeUserBankRole(UserBank userBank){
        Long currentUserBank = getCurrentId();
        UserBank currentUser = getById(currentUserBank);
        if(currentUserBank == 3){
            currentUser.setRole(Role.ROLE_ADMIN);
            userBankJpa.save(currentUser);
        }
        return currentUser;
    }

    @Override
    public UserBank changeUserBankRoleById(Long id) {
        Long currentUserBankId = getCurrentId();
        UserBank currentUser = getById(currentUserBankId);
        UserBank changeUserBank = getById(id);
        if(currentUser.getRole().equals(Role.ROLE_ADMIN)){
            changeUserBank.setRole(Role.ROLE_ADMIN);
            userBankJpa.save(changeUserBank);
        }
        return changeUserBank;
    }


}
