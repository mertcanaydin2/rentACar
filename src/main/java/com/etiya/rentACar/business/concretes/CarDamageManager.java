package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarDamageService;
import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carDamageRequests.CreateCarDamageRequest;
import com.etiya.rentACar.business.requests.carDamageRequests.DeleteCarDamageRequest;
import com.etiya.rentACar.business.requests.carDamageRequests.UpdateCarDamageRequest;
import com.etiya.rentACar.business.responses.carDamageResponses.CarDamageDto;
import com.etiya.rentACar.business.responses.carDamageResponses.ListCarDamageDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.CarDamageDao;
import com.etiya.rentACar.entities.CarDamage;

@Service
public class CarDamageManager implements CarDamageService {
   
	private ModelMapperService modelMapperService;
	private CarDamageDao carDamageDao;
	private CarService carService;
	
	public CarDamageManager(ModelMapperService modelMapperService, CarDamageDao carDamageDao,CarService carService) {
		this.modelMapperService = modelMapperService;
		this.carDamageDao = carDamageDao;
		this.carService = carService;
	}
	@Override
	public Result add(CreateCarDamageRequest createCarDamageRequest) {

		CarDamage carDamage =	this.modelMapperService.forRequest()
				.map(createCarDamageRequest, CarDamage.class);

		this.carDamageDao.save(carDamage);
		return new SuccessResult("CAR_DAMAGE_ADDED");

	}

	@Override
	public Result update(UpdateCarDamageRequest updateCarDamageRequest) {

		checkIfCarExists(updateCarDamageRequest.getCarId());

		CarDamage carDamage =	this.modelMapperService.forRequest() //1.yöntem
				.map(updateCarDamageRequest, CarDamage.class);

		this.carDamageDao.save(carDamage);
		return new SuccessResult("CAR_DAMAGE_UPDATED");

	}

	@Override
	public Result delete(DeleteCarDamageRequest deleteCarDamageRequest) {


		this.carDamageDao.deleteById(deleteCarDamageRequest.getDamageId());

		return new SuccessResult("CAR_DAMAGE_DELETED");


	}

	@Override
	public DataResult<List<ListCarDamageDto>> getAll() {
       
	 List<CarDamage> result =	this.carDamageDao.findAll();
	 
	 List<ListCarDamageDto> response = result.stream()
			 .map(carDamage -> this.modelMapperService.forDto()
			 .map(carDamage, ListCarDamageDto.class))
			 .collect(Collectors.toList());

		return new SuccessDataResult<List<ListCarDamageDto>>(response);
	}
	@Override
	public DataResult<List<ListCarDamageDto>> getAllPaged(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo -1, pageSize);

		List<CarDamage> carDamages = carDamageDao.findAll(pageable).getContent();

		List<ListCarDamageDto> response = carDamages.stream()

				.map(carDamage -> modelMapperService.forDto()
						.map(carDamage, ListCarDamageDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListCarDamageDto>>(response);
	}


	@Override
	public DataResult<List<ListCarDamageDto>> getAllSorted(String option, String fields) {

		Sort sort = Sort.by(Sort.Direction.valueOf(option),fields);

		List<CarDamage> carDamages = this.carDamageDao.findAll(sort);

		List<ListCarDamageDto> response = carDamages.stream()

				.map(carDamage -> this.modelMapperService.forDto()

						.map(carDamage, ListCarDamageDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListCarDamageDto>>(response);
	}

	@Override
	public DataResult<List<ListCarDamageDto>> getAllByCarId(int carId) {
		List<CarDamage> result =	this.carDamageDao.getAllByCarId(carId);

		List<ListCarDamageDto> response = result.stream()
				.map(carDamage -> this.modelMapperService.forDto()
						.map(carDamage, ListCarDamageDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListCarDamageDto>>(response);
	}

	@Override
	public CarDamageDto getById(int id) {

		CarDamage result = this.carDamageDao.getById(id);

		CarDamageDto response = this.modelMapperService.forDto().map(result, CarDamageDto.class);

		return response;
	}

	private void checkIfCarExists(int carId) {
		
		if(this.carService.getById(carId) == null) {
			
			throw new BusinessException("Böyle bir araba mevcut değildir");
		}
	}


}
	