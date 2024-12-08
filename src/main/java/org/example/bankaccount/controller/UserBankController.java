package org.example.bankaccount.controller;

import jakarta.validation.Valid;
import org.example.bankaccount.converter.Converter;
import org.example.bankaccount.dto.UserBankCreateDto;
import org.example.bankaccount.dto.UserBankResponseDto;
import org.example.bankaccount.entity.UserBank;
import org.example.bankaccount.security.AuthenticationService;
import org.example.bankaccount.security.model.JwtAuthenticationResponse;
import org.example.bankaccount.security.model.SignInRequest;
import org.example.bankaccount.service.UserBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user_bank")
public class UserBankController {

    @Autowired
    private UserBankService userBankService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Converter<UserBank, UserBankCreateDto, UserBankResponseDto> userCreateConverter;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public List<UserBank> getAll(){
        return userBankService.getAll();
    }

    @GetMapping("/{id}")
    public UserBank getById(@PathVariable(name = "id") Long id){
        return userBankService.getById(id);
    }

    @GetMapping("/search")
    public UserBank getByName(@RequestParam(name ="name") String name){
        return userBankService.getByName(name);
    }

    @PostMapping
    public UserBankResponseDto create(@RequestBody @Valid UserBankCreateDto userBankCreateDto){
        UserBank userBank = userCreateConverter.toEntity(userBankCreateDto);
        userBank.setPassword(passwordEncoder.encode(userBank.getPassword()));
        UserBank userFromDataBase = userBankService.create(userBank);
        return userCreateConverter.toDto(userFromDataBase);
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody SignInRequest request) {
        return authenticationService.authenticate(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        userBankService.deleteById(id);
    }


}
