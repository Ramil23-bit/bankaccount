package org.example.bankaccount.controller;

import org.example.bankaccount.entity.Account;
import org.example.bankaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Account> getById(@PathVariable Long id){
        return accountService.getById(id);
    }

    @PostMapping
    public Account create(@RequestBody Account account){
        return accountService.create(account);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        accountService.getById(id);
    }
}
