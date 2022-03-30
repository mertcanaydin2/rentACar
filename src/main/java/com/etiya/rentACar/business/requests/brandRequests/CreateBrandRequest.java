package com.etiya.rentACar.business.requests.brandRequests;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get ve set
@AllArgsConstructor //
@NoArgsConstructor //parametresiz const
public class CreateBrandRequest {
	
	@JsonIgnore
	private int brandId;
	
	@NotNull
	@Length(min = 2, max = 20)
	private String brandName;
    
	
}
