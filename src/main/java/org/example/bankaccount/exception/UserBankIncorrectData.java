package org.example.bankaccount.exception;

public class UserBankIncorrectData extends RuntimeException{

    public UserBankIncorrectData(String message) {
        super(message);
    }
}
