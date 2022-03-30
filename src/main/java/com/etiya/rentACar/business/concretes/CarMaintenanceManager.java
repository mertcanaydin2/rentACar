package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.rentACar.business.constants.BusinessMessages;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import org.hibernate.query.criteria.internal.BasicPathUsageException;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarMaintenanceService;
import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.CreateCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.DeleteCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.UpdateCarMaintenanceRequest;
import com.etiya.rentACar.business.responses.carMaintenanceResponses.ListCarMaintenanceDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.etiya.rentACar.entities.CarMaintenance;


@Service
public class CarMaintenanceManager implements CarMaintenanceService {

	private CarMaintenanceDao carMaintenanceDao;
	private ModelMapperService modelMapperService;
	private CarService carService;


	public CarMaintenanceManager(CarMaintenanceDao carMaintenanceDao, ModelMapperService modelMapperService, CarService carService) {
		
		this.carMaintenanceDao = carMaintenanceDao;
		this.modelMapperService = modelMapperService;
		this.carService = carService;
	}

	
	@Override
	public Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest) {

		checkIfCarId(createCarMaintenanceRequest.getCarId());
		
		CarMaintenance carMaintenance = modelMapperService.forRequest()
				.map(createCarMaintenanceRequest, CarMaintenance.class);
		
		this.carMaintenanceDao.save(carMaintenance);

		return new SuccessResult("CAR_MAINTENANCE_ADDED");
		
		
		
	}

	@Override
	public Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		
		CarMaintenance carMaintenance = this.modelMapperService.forRequest()
				.map(updateCarMaintenanceRequest, CarMaintenance.class);
	        
		this.carMaintenanceDao.save(carMaintenance);

		return new SuccessResult("CAR_MAINTENANCE_UPDATED");

	}



	@Override
	public Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {
		
		this.carMaintenanceDao.deleteById(deleteCarMaintenanceRequest.getMaintenanceId());

		return new SuccessResult("CAR_MAINTENANCE_DELETED");

	}
	@Override
	public DataResult<List<ListCarMaintenanceDto>> getAll() {
		
		List<CarMaintenance> carMaintenances = this.carMaintenanceDao.findAll();
		
        List<ListCarMaintenanceDto> response = carMaintenances.stream()
                .map(carMaintenance -> modelMapperService.forDto()
                		.map(carMaintenance, ListCarMaintenanceDto.class))
                .collect(Collectors.toList());

		return new SuccessDataResult<List<ListCarMaintenanceDto>>(response);
	}

	@Override
	public DataResult<List<ListCarMaintenanceDto>> getByCarId(int carId) {
		
		List<CarMaintenance> carMaintenances = this.carMaintenanceDao.getByCarId(carId);
		
        List<ListCarMaintenanceDto> response = carMaintenances.stream()
                .map(carMaintenance -> this.modelMapperService.forDto()
                        .map(carMaintenance, ListCarMaintenanceDto.class))
                .collect(Collectors.toList());
        
        return new SuccessDataResult<List<ListCarMaintenanceDto>>(response);
	}


	private void checkIfCarId(int carId) {
		
		 if (carMaintenanceDao.existsMaintenanceByCarId(carId)) {
			 
	            throw new BusinessException(BusinessMessages.MaintenanceMessage.CAR_UNDERMAİNTENANCE);
	        }		
	}
	
	


}
