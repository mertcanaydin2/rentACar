package com.etiya.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Color;

@Repository
public interface ColorDao extends JpaRepository<Color, Integer>{
      
   
	boolean existsByNameIgnoreCase(String name);
}
