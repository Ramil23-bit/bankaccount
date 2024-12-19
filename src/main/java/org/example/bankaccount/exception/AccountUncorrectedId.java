package org.example.bankaccount.exception;

public class AccountUncorrectedId extends RuntimeException{

    public AccountUncorrectedId(String message) {
        super(message);
    }
}
