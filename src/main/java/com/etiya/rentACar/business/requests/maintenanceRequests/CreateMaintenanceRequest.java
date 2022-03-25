package com.etiya.rentACar.business.requests.maintenanceRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaintenanceRequest {
    @JsonIgnore
    private int id;

    private String dateAdded;
    private String dateReturned;
    private String statement;
    private int carId;

}
