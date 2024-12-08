package org.example.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.bankaccount.enums.CurrencyType;

import java.math.BigDecimal;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {

    private Long id;

    private BigDecimal amount;

}
