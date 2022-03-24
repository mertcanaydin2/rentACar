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

// Bir veritabanında değişiklik yapma işlemi create için ayrı delete için ayrı update için ayrı olmalı