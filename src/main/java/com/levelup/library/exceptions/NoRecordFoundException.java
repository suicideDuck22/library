package com.levelup.library.exceptions;

public class NoRecordFoundException extends RuntimeException {
    private String message;

    public NoRecordFoundException(){}
    public NoRecordFoundException(String message) {
        super();
        this.message = message;
    }
}
