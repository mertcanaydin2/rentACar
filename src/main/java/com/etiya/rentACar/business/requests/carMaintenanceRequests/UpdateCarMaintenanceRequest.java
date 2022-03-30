package com.etiya.rentACar.business.requests.carMaintenanceRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarMaintenanceRequest {

	
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
