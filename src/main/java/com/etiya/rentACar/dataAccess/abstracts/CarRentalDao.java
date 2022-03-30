package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.business.responses.carRentalResponses.ListCarRentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.CarMaintenance;
import com.etiya.rentACar.entities.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRentalDao extends JpaRepository<CarRental , Integer> {
    //List<CarRental> getByCarId(int id);
    List<CarRental> getAllByCarId(int carId);
    //List<CarRental> getByRentDateReturnDate(LocalDate rentDate, LocalDate returnDate);
}
