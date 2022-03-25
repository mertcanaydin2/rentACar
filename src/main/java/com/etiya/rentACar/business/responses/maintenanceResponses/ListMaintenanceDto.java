package com.etiya.rentACar.business.responses.maintenanceResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListMaintenanceDto {

    private int id;
    private String dateAdded;
    private String dateReturned;
    private String statement;
    private int carId;
    private String carDescription;
}
