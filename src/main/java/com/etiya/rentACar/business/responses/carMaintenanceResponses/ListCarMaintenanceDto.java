package com.etiya.rentACar.business.responses.carMaintenanceResponses;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListCarMaintenanceDto {

	private int maintananceId;

	private String carDescription;
	
	private String description;

	private LocalDate dateAdded;

	private LocalDate dateReturned;
	    
    //private int carId;

}
