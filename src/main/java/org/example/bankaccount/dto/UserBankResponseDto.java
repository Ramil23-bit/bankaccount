package org.example.bankaccount.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.bankaccount.entity.Account;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class UserBankResponseDto {

    private Long id;

    @NotNull
    @NotBlank
    private String login;

    @Email
    private String email;

    private List<Account> accountList = new ArrayList<>();

    public UserBankResponseDto(Long id, String login, String email, List<Account> accountList) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.accountList = accountList;
    }
}
