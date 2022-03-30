package com.etiya.rentACar.business.requests.brandRequests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get ve set
@AllArgsConstructor //
@NoArgsConstructor //parametresiz const
public class DeleteBrandRequest {
	
	private int brandId;

}
