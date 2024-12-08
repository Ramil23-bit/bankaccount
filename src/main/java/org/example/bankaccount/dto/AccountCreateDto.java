package org.example.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bankaccount.enums.CurrencyType;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateDto {

    private Long id;

    private BigDecimal amount;

    private CurrencyType currencyType;
}
