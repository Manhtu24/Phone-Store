package com.MTlovec.Phone_Store.exception;

public class PasswordNotMatchException extends  RuntimeException{
    public PasswordNotMatchException(String message) {
        super(message);
    }
}
