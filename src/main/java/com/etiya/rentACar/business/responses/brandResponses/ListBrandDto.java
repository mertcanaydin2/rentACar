package com.etiya.rentACar.business.responses.brandResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListBrandDto {
	
	private int brandId;
	
	private String brandName;
}
