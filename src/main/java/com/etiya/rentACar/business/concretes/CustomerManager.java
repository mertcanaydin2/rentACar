package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CustomerService;
import com.etiya.rentACar.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.business.responses.carRentalResponses.ListCarRentalDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.business.responses.customerResponses.ListCustomerDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CustomerDao;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.CarRental;
import com.etiya.rentACar.entities.Customer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;
    private ModelMapperService modelMapperService;




    public CustomerManager(CustomerDao customerDao, ModelMapperService modelMapperService) {
        this.customerDao = customerDao;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public Result add(CreateCustomerRequest createCustomerRequest) {

        Customer customer = this.modelMapperService.forRequest()

                .map(createCustomerRequest, Customer.class);

        this.customerDao.save(customer);

        return new SuccessResult("CUSTOMER_ADDED");
    }

    @Override
    public Result update(UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = this.modelMapperService.forRequest()

                .map(updateCustomerRequest, Customer.class);

        this.customerDao.save(customer);

        return new SuccessResult("CUSTOMER_UPDATED");

    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {

        this.customerDao.deleteById(deleteCustomerRequest.getCustomerId());

        return new SuccessResult("CUSTOMER_DELETED");

    }

    @Override
    public DataResult<List<ListCustomerDto>> getAll() {

        List<Customer> customers = this.customerDao.findAll();

        List<ListCustomerDto> response = customers.stream()

                .map(customer -> this.modelMapperService.forDto()
                        .map(customer, ListCustomerDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCustomerDto>>(response);
    }

    @Override
    public DataResult<List<ListCustomerDto>> getAllPaged(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        List<Customer> customers = this.customerDao.findAll(pageable).getContent();

        List<ListCustomerDto> response = customers.stream()

                .map(customer -> this.modelMapperService.forDto()
                        .map(customer, ListCustomerDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCustomerDto>>(response);
    }

   /* @Override
    public DataResult<List<ListCustomerDto>> getAllSorted(String option, String fields) {

        Sort sort = Sort.by(Sort.Direction.valueOf(option),fields);

        List<Customer> customers = this.customerDao.findAll(sort);

        List<ListCustomerDto> response = customers.stream()

                .map(customer -> this.modelMapperService.forDto()

                        .map(customer, ListCustomerDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCustomerDto>>(response);
    }*/
}
