package com.etiya.rentACar.business.requests.carRentalRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRentalRequest {
    @JsonIgnore
    private int rentalId;

    @NotNull
    private int customerId;

    @NotNull
    private LocalDate rentDate;

    private LocalDate returnDate;
}
