package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface CarService {

    
    CarDto getById(int id);

	DataResult<List<ListCarDto>> getAll();
	DataResult<List<ListCarDto>> getAllByModelYear(int modelYear);
	DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize); // hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç tane olsuna göre yapılandırır.
	DataResult<List<ListCarDto>> getAllSorted(String option, String fields); // sorted sıralı demektir.
	//List<ListCarDto> getByCarId(int id);
	
	
	
	
	Result add(CreateCarRequest createCarRequest);
	Result update(UpdateCarRequest updateCarRequest);
	Result delete(DeleteCarRequest deleteCarRequest);

    void checkIfCarAvaible(int carId);


//	ListCarDto getById(int id);


	//ListCarDto getByCarId(int carId);

}
