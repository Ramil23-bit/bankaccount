package org.example.bankaccount.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bankaccount.entity.Account;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBankCreateDto {

    private String name;

    @NotNull
    @NotBlank
    private String login;

    @Email
    private String email;

    private String password;

    private List<Account> accountList;
}
