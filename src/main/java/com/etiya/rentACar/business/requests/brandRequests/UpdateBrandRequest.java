package com.etiya.rentACar.business.requests.brandRequests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data //get ve set
@AllArgsConstructor //
@NoArgsConstructor //parametresiz const
public class UpdateBrandRequest {
	
	private int brandId;

	@NotNull
	@Length(min = 2, max = 20)
	private String brandName;
}
