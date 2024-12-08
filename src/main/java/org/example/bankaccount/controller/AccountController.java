package org.example.bankaccount.controller;

import jakarta.validation.Valid;
import org.example.bankaccount.converter.Converter;
import org.example.bankaccount.dto.AccountCreateDto;
import org.example.bankaccount.dto.AccountResponseDto;
import org.example.bankaccount.entity.Account;
import org.example.bankaccount.entity.UserBank;
import org.example.bankaccount.security.JwtAuthenticationFilter;
import org.example.bankaccount.service.AccountService;
import org.example.bankaccount.service.UserBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private Converter<Account, AccountCreateDto, AccountResponseDto> converterAccount;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER_BANK')")
    public Account getById(@PathVariable(name = "id") Long id){
        return accountService.getById(id);
    }

    @GetMapping("/current_user_bank")
    public String getAllUserBank(){
        return accountService.getCurrentUserBankName();
    }

    @PostMapping
    public AccountResponseDto create(@RequestBody @Valid AccountCreateDto accountCreateDto){
        Account account = converterAccount.toEntity(accountCreateDto);
        Account accountFromDataBase = accountService.create(account);
        return converterAccount.toDto(accountFromDataBase);
    }

//    @PostMapping
//    public Account createForUserBank(@RequestBody Account account, @PathVariable(name = "id") Long id){
//        return new Account();
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        accountService.getById(id);
    }
}
