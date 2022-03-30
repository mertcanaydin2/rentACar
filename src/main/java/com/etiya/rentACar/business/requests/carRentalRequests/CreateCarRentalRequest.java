package com.etiya.rentACar.business.requests.carRentalRequests;

import com.etiya.rentACar.entities.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRentalRequest {

    @JsonIgnore
    private int rentalId;

    @NotNull
    private int customerId;

    @NotNull
    private LocalDate rentDate;

    private LocalDate returnDate;

    private int carId;

}
