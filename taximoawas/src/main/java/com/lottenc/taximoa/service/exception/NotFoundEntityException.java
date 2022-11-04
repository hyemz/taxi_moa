package com.lottenc.taximoa.service.exception;

public class NotFoundEntityException extends RuntimeException{
    private String key;

    public NotFoundEntityException(String name) {
        super();
        this.key = key;
    }

    public String getkey() {
        return key;
    }
}

