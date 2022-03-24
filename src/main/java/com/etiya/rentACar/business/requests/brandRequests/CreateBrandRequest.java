package com.etiya.rentACar.business.requests.brandRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class CreateBrandRequest {
    @JsonIgnore
    private int id;

    private String name;

}
