package org.example.bankaccount.exception;

public class UserHasAccountThisCurrency extends RuntimeException{

    public UserHasAccountThisCurrency(String message){
        super(message);
    }
}
