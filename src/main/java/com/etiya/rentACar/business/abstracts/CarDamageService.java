package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carDamageRequests.CreateCarDamageRequest;
import com.etiya.rentACar.business.requests.carDamageRequests.DeleteCarDamageRequest;
import com.etiya.rentACar.business.requests.carDamageRequests.UpdateCarDamageRequest;
import com.etiya.rentACar.business.responses.carDamageResponses.CarDamageDto;
import com.etiya.rentACar.business.responses.carDamageResponses.ListCarDamageDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface CarDamageService {
	
	CarDamageDto getById(int id);
	
	DataResult<List<ListCarDamageDto>> getAll();
	DataResult<List<ListCarDamageDto>> getAllByCarId(int carId);
	DataResult<List<ListCarDamageDto>> getAllPaged(int pageNo , int pageSize);
	DataResult<List<ListCarDamageDto>> getAllSorted(String option, String fields);

	
	Result add(CreateCarDamageRequest createCarDamageRequest);
	Result update(UpdateCarDamageRequest updateCarDamageRequest);
	Result delete(DeleteCarDamageRequest deleteCarDamageRequest);

	
}
/*
void add(CreateCarDamageRequest createDamageRequest);

List<ListCarDamageDto> getAll();

List<ListCarDamageDto> getByCarId(int id);

List<ListCarDamageDto> getAllPaged(int pageNo, int pageSize); // hangi sayfa ve bir sayfada kaç tane olsun .. sayfada
															// kaç tane olsuna göre yapılandırır.

List<ListCarDamageDto> getAllSorted(String option, String field); // sorted sıralı demektir.*/