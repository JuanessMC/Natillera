package com.natillera.demo.domain.exception;

public class NegativeNotAllowedException extends RuntimeException{
    public NegativeNotAllowedException(String message) {
        super(message);
    }
}
