package com.zyx.exception;

public class NobkException extends RuntimeException{
    public NobkException(String messae){
        super(messae);
    }
    public NobkException(String message,Throwable cause){
        super(message,cause);
    }
}
