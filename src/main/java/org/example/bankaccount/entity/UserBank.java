package org.example.bankaccount.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_bank")
public class UserBank {
    @Id
    private Long id;

    private String name;

    private String login;

    private String password;

    private String email;

}
