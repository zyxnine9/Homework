package com.zyx.exception;

public class BRexception extends RuntimeException {
    public BRexception(String message){
        super(message);
    }
    public BRexception(String message,Throwable cause){
        super(message,cause);
    }
}
