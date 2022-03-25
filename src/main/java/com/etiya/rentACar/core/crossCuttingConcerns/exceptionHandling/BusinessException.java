package com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
