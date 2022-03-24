package com.etiya.rentACar.business.responses.carResponses;


import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListCarDto {

    private int id;
    private double dailyPrice;
    private String description;
    private double modelYear;
    private String colorName;
    private String brandName;
}
