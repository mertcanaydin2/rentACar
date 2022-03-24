package com.etiya.rentACar.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Brand;



@Repository
public interface BrandDao extends JpaRepository<Brand, Integer> {


    Boolean existsBrandByName(String name);
}

