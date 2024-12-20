package org.example.bankaccount.exception;

public class AccountIncorrectData extends RuntimeException{

    public AccountIncorrectData(String message) {
        super(message);
    }
}
