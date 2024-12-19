package org.example.bankaccount.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bankaccount.enums.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_bank")
public class UserBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role = Role.ROLE_USER_BANK;

    @Email
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "user_bank_id")
    private List<Account> accountList;

    public UserBank(Long id, String login, Role role) {
        this.id = id;
        this.login = login;
        this.role = role;
    }


    public UserBank(String name, String login, String password, String email, List<Account> accountList) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.accountList = accountList;
    }
}
