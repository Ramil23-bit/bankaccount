package org.example.bankaccount.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bankaccount.enums.CurrencyType;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type", columnDefinition = "VARCHAR(60)")
    private CurrencyType currencyType;


//    @JoinColumn(name = "user")
//    private UserBank user;

    public Account(Long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public Account(Long id, BigDecimal amount, CurrencyType currencyType, Long number) {
        this.id = id;
        this.amount = amount;
        this.currencyType = currencyType;
        this.number = number;
    }
}
