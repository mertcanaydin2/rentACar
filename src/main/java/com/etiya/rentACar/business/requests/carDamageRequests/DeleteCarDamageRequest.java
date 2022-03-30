package com.etiya.rentACar.business.requests.carDamageRequests;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get ve set
@AllArgsConstructor //parametreli constructor
@NoArgsConstructor // parametresiz constructor
public class DeleteCarDamageRequest {
    
	
	private int damageId;

	
}
