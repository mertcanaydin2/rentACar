package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CarRentalService;
import com.etiya.rentACar.business.requests.carRentalRequests.CreateCarRentalRequest;
import com.etiya.rentACar.business.requests.carRentalRequests.DeleteCarRentalRequest;
import com.etiya.rentACar.business.requests.carRentalRequests.UpdateCarRentalRequest;
import com.etiya.rentACar.business.responses.carRentalResponses.ListCarRentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class CarRentalsController {
    private CarRentalService carRentalService;

    public CarRentalsController(CarRentalService carRentalService) {

        this.carRentalService = carRentalService;
    }
    @PostMapping("/add") //valid dediğimizde crreate de yazdığımız anatosyonların devreye girmesini sağlar
    public Result add(@RequestBody @Valid CreateCarRentalRequest createCarRentalRequest) {

        return this.carRentalService.add(createCarRentalRequest);
    }
    @PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateCarRentalRequest updateCarRentalRequest) {

        return  this.carRentalService.update(updateCarRentalRequest);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteCarRentalRequest deleteCarRentalRequest) {

        return this.carRentalService.delete(deleteCarRentalRequest);
    }
    @GetMapping("/getall")
    public DataResult<List<ListCarRentalDto>> getAll(){

        return this.carRentalService.getAll();
    }

    @GetMapping("/getallpaged")		//hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç tane olsuna göre yapılandırır.
    public DataResult<List<ListCarRentalDto>> getAllPaged(int pageNo,int pageSize) {

        return this.carRentalService.getAllPaged(pageNo, pageSize);
    }

    @GetMapping("/getallsorted")//sorted sıralı demek
    public  DataResult<List<ListCarRentalDto>> getAllSorted(String option,String fields){

        return this.carRentalService.getAllSorted(option,fields);
    }
    @GetMapping("/getallbycarid")
    public DataResult<List<ListCarRentalDto>> getAllByCarId(@RequestParam("carId") int id){

        return this.carRentalService.getAllByCarId(id);
    }
}
