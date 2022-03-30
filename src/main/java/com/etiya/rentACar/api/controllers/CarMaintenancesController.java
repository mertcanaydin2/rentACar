package com.etiya.rentACar.api.controllers;

import java.util.List;

import com.etiya.rentACar.business.requests.carMaintenanceRequests.DeleteCarMaintenanceRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.CarMaintenanceService;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.CreateCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.UpdateCarMaintenanceRequest;
import com.etiya.rentACar.business.responses.carMaintenanceResponses.ListCarMaintenanceDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/maintenances")
public class CarMaintenancesController {

	private CarMaintenanceService carMaintenanceService;


	public CarMaintenancesController(CarMaintenanceService carMaintenanceService) {

		this.carMaintenanceService = carMaintenanceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCarMaintenanceRequest createCarMaintenanceRequest) {

		return this.carMaintenanceService.add(createCarMaintenanceRequest); //
	}

	@PostMapping("/update")
	public Result update(@RequestBody @Valid UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {

		return this.carMaintenanceService.update(updateCarMaintenanceRequest);
	}
	@PostMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {

		return this.carMaintenanceService.delete(deleteCarMaintenanceRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<ListCarMaintenanceDto>> getAll() {

		return this.carMaintenanceService.getAll();
	}

	@GetMapping("/getbycarid/{id}")
	public DataResult<List<ListCarMaintenanceDto>> getByCarId(int id) {

		return this.carMaintenanceService.getByCarId(id);
	}

}
