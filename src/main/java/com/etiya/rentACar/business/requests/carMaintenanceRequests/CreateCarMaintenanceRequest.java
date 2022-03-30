package com.etiya.rentACar.business.requests.carMaintenanceRequests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/*import com.etiya.rentACar.entities.Situations;*/
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarMaintenanceRequest {

	@JsonIgnore
	private int maintenanceId;
     
	@NotNull
	private LocalDate dateAdded;

	private LocalDate dateReturned;
	
	@NotNull
	@Length(min = 2 , max = 100)
	private String description;
	
	@NotNull
	@Length(min = 2, max = 100)
	private String carDescription;

	@NotNull
	private int carId;
	

	
	

	
}
