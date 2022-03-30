package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.CarRental;
import com.etiya.rentACar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
