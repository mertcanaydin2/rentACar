package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carMaintenanceRequests.CreateCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.DeleteCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.UpdateCarMaintenanceRequest;
import com.etiya.rentACar.business.responses.carMaintenanceResponses.ListCarMaintenanceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface CarMaintenanceService {
	
	
	DataResult<List<ListCarMaintenanceDto>> getAll();
	DataResult<List<ListCarMaintenanceDto>> getByCarId(int carId);
	


	
	Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest); //
	Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest);
	Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest);



}