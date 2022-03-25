package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenancesController {


    private MaintenanceService maintenanceService;


    public MaintenancesController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest) throws ParseException {
        this.maintenanceService.add(createMaintenanceRequest);
    }

    @GetMapping("/getall")
    public List<ListMaintenanceDto> getAll(){
        return this.maintenanceService.getAll();
    }

    /*@GetMapping("/getstatement")
    public String getMaintenanceByStatement(int carId){
        return this.maintenanceService.getMaintenanceByStatement();
    }*/

    @GetMapping("/get/{id}")
    public List<ListMaintenanceDto> getByCarId(int id){
        return this.maintenanceService.getByCarId(id);
    }
}
