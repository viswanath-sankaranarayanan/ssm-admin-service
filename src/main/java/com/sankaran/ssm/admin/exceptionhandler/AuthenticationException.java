package com.sankaran.ssm.admin.exceptionhandler;

public class AuthenticationException extends Exception{

    public AuthenticationException(String message){
        super(message);
    }
}
