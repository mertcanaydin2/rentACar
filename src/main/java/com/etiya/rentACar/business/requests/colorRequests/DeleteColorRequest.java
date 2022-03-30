package com.etiya.rentACar.business.requests.colorRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get ve set
@AllArgsConstructor //
@NoArgsConstructor // parametresiz const
public class DeleteColorRequest {
	
	private int colorId;

}
