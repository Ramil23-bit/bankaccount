package org.example.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.bankaccount.enums.CurrencyType;

import java.math.BigDecimal;
@Getter
@NoArgsConstructor
public class AccountResponseDto {

    private Long id;

    private BigDecimal amount;

    public AccountResponseDto(Long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }
}
