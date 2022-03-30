package com.etiya.rentACar.business.requests.colorRequests;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


@Data //get ve set
@AllArgsConstructor //
@NoArgsConstructor //parametresiz const
public class CreateColorRequest {
	
	  @JsonIgnore
	  private int colorId;

	  @NotNull
	  @Length(min = 2,max = 50 )
	  private String colorName;
}

