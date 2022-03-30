package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.carRentalRequests.CreateCarRentalRequest;
import com.etiya.rentACar.business.requests.carRentalRequests.DeleteCarRentalRequest;
import com.etiya.rentACar.business.requests.carRentalRequests.UpdateCarRentalRequest;
import com.etiya.rentACar.business.responses.carRentalResponses.ListCarRentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface CarRentalService {



    DataResult<List<ListCarRentalDto>> getAll();
    DataResult<List<ListCarRentalDto>> getAllPaged(int pageNo, int pageSize); // hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç tane olsuna göre yapılandırır.
    DataResult<List<ListCarRentalDto>> getAllSorted(String option, String fields); // sorted sıralı demektir.
    DataResult<List<ListCarRentalDto>> getAllByCarId(int carId);






    Result add(CreateCarRentalRequest createCarRentalRequestRequest);
    Result update(UpdateCarRentalRequest updateCarRentalRequest);
    Result delete(DeleteCarRentalRequest deleteCarRentalRequest);
}
