package com.etiya.rentACar.business.requests.carRequests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

	
	private int carId;

	@NotNull //burayı bana sağlamak durumundasın
	@Min(1)
	@Max(10000)
	private double dailyPrice;

	@NotNull
	@Length(min = 2, max = 50)
	private String description;

	@NotNull
	@Max(2022)
	private int modelYear;

	@NotNull
	private int colorId;

	@NotNull
	private int brandId;
	
    //private CarStates statesName;

}
