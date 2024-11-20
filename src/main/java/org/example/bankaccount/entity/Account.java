package org.example.bankaccount.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {


    @Id
    private Long id;

    private Long number;

    private BigDecimal amount;

    private String currency;

}
