package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarRentalService;
import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carRentalRequests.CreateCarRentalRequest;
import com.etiya.rentACar.business.requests.carRentalRequests.DeleteCarRentalRequest;
import com.etiya.rentACar.business.requests.carRentalRequests.UpdateCarRentalRequest;
import com.etiya.rentACar.business.responses.carRentalResponses.ListCarRentalDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CarRentalDao;
import com.etiya.rentACar.entities.CarRental;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarRentalManager implements CarRentalService {

    private CarRentalDao carRentalDao;
    private ModelMapperService modelMapperService;
    private CarService carService;


    public CarRentalManager(CarRentalDao carRentalDao, ModelMapperService modelMapperService, CarService carService) {
        this.carRentalDao = carRentalDao;
        this.modelMapperService = modelMapperService;
        this.carService = carService;
    }

    @Override
    public Result add(CreateCarRentalRequest createCarRentalRequest) {

        carService.checkIfCarAvaible(createCarRentalRequest.getCarId());


        CarRental carRental = this.modelMapperService.forRequest()

                .map(createCarRentalRequest, CarRental.class);

        carRental.setReturnDate(null);

        this.carRentalDao.save(carRental);

        return new SuccessResult("CAR_ADDED_TO_RENTAL");
    }

    @Override
    public Result update(UpdateCarRentalRequest updateCarRentalRequest) {

        CarRental carRental = this.modelMapperService.forRequest()

                .map(updateCarRentalRequest, CarRental.class);

        this.carRentalDao.save(carRental);

        return new SuccessResult("CAR_RENTAL_UPDATE");
    }

    @Override
    public Result delete(DeleteCarRentalRequest deleteCarRentalRequest) {

        this.carRentalDao.deleteById(deleteCarRentalRequest.getRentalId());

        return new SuccessResult("CAR_RENTAL_DELETED");
    }

    @Override
    public DataResult<List<ListCarRentalDto>> getAll() {

        List<CarRental> carRentals = this.carRentalDao.findAll();

        List<ListCarRentalDto> response = carRentals.stream()

                .map(carRental -> this.modelMapperService.forDto()
                        .map(carRental, ListCarRentalDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarRentalDto>>(response);
    }

    @Override
    public DataResult<List<ListCarRentalDto>> getAllPaged(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        List<CarRental> carRentals = this.carRentalDao.findAll(pageable).getContent();

        List<ListCarRentalDto> response = carRentals.stream()

                .map(carRental -> this.modelMapperService.forDto()
                        .map(carRental, ListCarRentalDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarRentalDto>>(response);
    }

    @Override
    public DataResult<List<ListCarRentalDto>> getAllSorted(String option, String fields) {

        Sort sort = Sort.by(Sort.Direction.valueOf(option), fields);

        List<CarRental> carRentals = this.carRentalDao.findAll(sort);

        List<ListCarRentalDto> response = carRentals.stream()

                .map(carRental -> this.modelMapperService.forDto()
                        .map(carRental, ListCarRentalDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarRentalDto>>(response);
    }

    @Override
    public DataResult<List<ListCarRentalDto>> getAllByCarId(int carId) {
        List<CarRental> result = this.carRentalDao.getAllByCarId(carId);

        List<ListCarRentalDto> response = result.stream()
                .map(carRental -> this.modelMapperService.forDto()
                        .map(carRental, ListCarRentalDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarRentalDto>>(response);
    }


}
