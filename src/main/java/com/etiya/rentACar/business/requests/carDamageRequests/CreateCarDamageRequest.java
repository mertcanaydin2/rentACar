package com.etiya.rentACar.business.requests.carDamageRequests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get ve set
@AllArgsConstructor //parametreli constructor
@NoArgsConstructor // parametresiz constructor
public class CreateCarDamageRequest {

	@JsonIgnore
	private int damageId;

	@NotNull
	private int carId;

	@NotNull
	private LocalDate accidentDate;

	@NotNull
	@Length(min = 2 ,max = 50)
	private String description;

}