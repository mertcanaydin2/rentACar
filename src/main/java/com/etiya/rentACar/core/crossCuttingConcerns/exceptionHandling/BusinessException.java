package com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {
 public BusinessException(String message) {
	 
	 super(message);
 }
}
