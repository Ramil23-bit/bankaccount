package org.example.bankaccount.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.bankaccount.enums.Role;
@Getter
@NoArgsConstructor
public class UserBankChangeRoleDto {

    private Long id;

    @NotBlank
    @NotNull
    private String login;

    private Role role;

    public UserBankChangeRoleDto(Long id, String login, Role role) {
        this.id = id;
        this.login = login;
        this.role = role;
    }
}
