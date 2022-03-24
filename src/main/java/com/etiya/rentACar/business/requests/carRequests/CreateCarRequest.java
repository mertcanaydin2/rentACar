package com.etiya.rentACar.business.requests.carRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCarRequest {
    @JsonIgnore
    private int id;

    private double dailyPrice;
    private String description;
    private double modelYear;
    private int colorId;
    private int brandId;
}