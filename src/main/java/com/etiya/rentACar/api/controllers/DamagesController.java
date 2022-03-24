package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.DamageService;
import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/damages")
public class DamagesController {

    private DamageService damageService;
    private CarService carService;
    private CarsController carsController;

    public DamagesController(DamageService damageService) {
        this.damageService = damageService;
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateDamageRequest createDamageRequest){

        damageService.add(createDamageRequest);
    }

    @GetMapping("/getall")
    public List<ListDamageDto> getAll() {
        return this.damageService.getAll();
    }

    @GetMapping("/get/{id}")
    public List<ListDamageDto> getByCarId(int id){
        return this.damageService.getByCarId(id);
    }
    @GetMapping("/get/getallpaged")
    public List<ListDamageDto> getAllPaged(int pageNo,int pageSize) {
        return this.damageService.getAllPaged(pageNo, pageSize);


    }
    @GetMapping("/get/getallsorted")
    public List<ListDamageDto> getAllSorted(String field,String option){
        return this.damageService.getAllSorted(field,option);

    }

}