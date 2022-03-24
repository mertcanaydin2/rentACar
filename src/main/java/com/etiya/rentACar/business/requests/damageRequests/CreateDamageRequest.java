package com.etiya.rentACar.business.requests.damageRequests;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDamageRequest {

    @JsonIgnore
    private int id;

    private int carId;
    private String description;
    private String date;

}
