package com.etiya.rentACar.business.requests.carRequests;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCarRequest {

	@JsonIgnore
	private int carId;

	@NotNull //burayı bana sağlamak durumundasın
	@Min(1)
	@Max(2000)
	private double dailyPrice;

	@NotNull
	@Length(min = 2, max = 50)
	private String description;

	@NotNull
	@Min(2015)
	private int modelYear;

	@NotNull
	private int colorId;

	@NotNull
	private int brandId;
	

	
}
