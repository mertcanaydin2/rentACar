package com.etiya.rentACar.business.responses.carDamageResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarDamageDto {
	
   
	private int damageId;

	private int carId;

	private LocalDate accidentDate;

	private String description;

	private String carDescription;

   
  
   }

   

