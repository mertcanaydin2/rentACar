package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.CarDamage;

@Repository
public interface CarDamageDao extends JpaRepository<CarDamage, Integer>{
 
   List<CarDamage> getAllByCarId(int carId);    
}
