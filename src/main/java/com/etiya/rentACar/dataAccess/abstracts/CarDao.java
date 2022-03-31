package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
    
	List<Car> getByModelYear(int modelYear);
    
    List<Car> getByModelYearIn(List<Integer> modelYears);
    
    List<Car> getByModelYearAndDailyPrice(int modelYear, double dailyPrice);
    
    List<Car> getByDescriptionContainsIgnoreCase(String description);
    
    Car getById(int id);

}
