package com.etiya.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@Bean // Bean bellekte uygulama çalıştığında injection yapmaya uygun bekletilen instancelar//uygulama çalıştığında ModelMapper instance'ı üretir
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
