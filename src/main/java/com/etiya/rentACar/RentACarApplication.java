package com.etiya.rentACar;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.etiya.rentACar.core.utilities.results.ErrorDataResult;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);

	}

	@Bean //İçinde sınıfların referanslarını tutar. Manuel olarak instance üretmemiz gereken sınıfları burada newleriz 

	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
		
		Map<String,String> validationErrors = new HashMap<String, String>();
		
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
			
		}
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors,"VALIDATION_ERROR(S)");
		
		return errorDataResult;
	}
}
