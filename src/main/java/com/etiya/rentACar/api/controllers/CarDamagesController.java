package com.etiya.rentACar.api.controllers;

import java.util.List;

import com.etiya.rentACar.business.requests.carDamageRequests.DeleteCarDamageRequest;
import com.etiya.rentACar.business.requests.carDamageRequests.UpdateCarDamageRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.CarDamageService;
import com.etiya.rentACar.business.requests.carDamageRequests.CreateCarDamageRequest;
import com.etiya.rentACar.business.responses.carDamageResponses.ListCarDamageDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/damages")
public class CarDamagesController {
	private CarDamageService carDamageService;

	public CarDamagesController(CarDamageService carDamageService) {

		this.carDamageService = carDamageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCarDamageRequest createCarDamageRequest) {

		return this.carDamageService.add(createCarDamageRequest);
	}
	@PostMapping("/update")
	public Result update(@RequestBody @Valid UpdateCarDamageRequest updateCarDamageRequest) {

		return this.carDamageService.update(updateCarDamageRequest);
	}
	@PostMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteCarDamageRequest deleteCarDamageRequest) {

		return this.carDamageService.delete(deleteCarDamageRequest);
	}
	@GetMapping("/getall")
	public DataResult<List<ListCarDamageDto>> getAll(){

		return this.carDamageService.getAll();
	}

	@GetMapping("/getbycarid")
	public DataResult<List<ListCarDamageDto>> getByCarId(@RequestParam("carId") int id){

		return this.carDamageService.getAllByCarId(id);
	}
	@GetMapping("/getallpaged")
	public DataResult<List<ListCarDamageDto>> getAllPaged(int pageNo,int pageSize) {

		return this.carDamageService.getAllPaged(pageNo, pageSize);
	}
	@GetMapping("/getallsorted")
	 public  DataResult<List<ListCarDamageDto>> getAllSorted(String option,String fields){

		return this.carDamageService.getAllSorted(option,fields);
	}
}
