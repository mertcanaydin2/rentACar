package com.etiya.rentACar.business.requests.customerRequests;

import com.etiya.rentACar.entities.CarRental;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    @JsonIgnore
    private int customerId;

    @NotNull
    @Length(min = 2,max = 20)
    private String firstName;

    @NotNull
    @Length(min = 2,max = 20)
    private String lastName;

}
