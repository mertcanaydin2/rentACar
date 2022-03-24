package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    private CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCarRequest createCarRequest) {

        this.carService.add(createCarRequest);
    }

    @GetMapping("/getall")
    public List<ListCarDto> getAll(){
        return this.carService.getAll();
    }

    @GetMapping("/getallbymodelyear")
    public List<ListCarDto> getAllByModelYear(@RequestParam("modelYear") double modelYear){
        return this.carService.getAllByModelYear(modelYear);
    }

    @GetMapping("/getallpaged")
    public List<ListCarDto> getAllPaged(int pageNo,int pageSize){
        return this.carService.getAllPaged(pageNo, pageSize);

    }
    @GetMapping("/getallsorted")
    public List<ListCarDto> getAllSorted(){
        return this.carService.getAllSorted();
    }
}
