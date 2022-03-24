package com.etiya.rentACar.business.responses.damageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDamageDto {

    private int id;
    private String description;
    private String date;
    private int carId;
    private String carDescription;
}
