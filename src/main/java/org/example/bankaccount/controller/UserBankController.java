package org.example.bankaccount.controller;

import org.example.bankaccount.entity.UserBank;
import org.example.bankaccount.service.UserBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user_bank")
public class UserBankController {
    @Autowired
    private UserBankService userBankService;

    @GetMapping
    public List<UserBank> getAll(){
        return userBankService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserBank> getById(@PathVariable Long id){
        return userBankService.getById(id);
    }

    @PostMapping
    public UserBank create(@RequestBody UserBank userBank){
        return userBankService.create(userBank);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userBankService.getById(id);
    }


}
