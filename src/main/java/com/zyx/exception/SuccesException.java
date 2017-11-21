package com.zyx.exception;

public class SuccesException extends RuntimeException {
    public SuccesException(String message){
        super(message);
    }
    public SuccesException(String message,Throwable cause){
        super(message, cause);
    }
}
