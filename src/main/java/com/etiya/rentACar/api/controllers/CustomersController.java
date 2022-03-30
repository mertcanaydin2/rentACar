package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CustomerService;
import com.etiya.rentACar.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.business.responses.customerResponses.ListCustomerDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    private CustomerService customerService;

    public CustomersController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping("/add") //valid dediğimizde crreate de yazdığımız anatosyonların devreye girmesini sağlar
    public Result add(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {

        return this.customerService.add(createCustomerRequest);
    }
    @PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {

        return  this.customerService.update(updateCustomerRequest);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteCustomerRequest deleteCustomerRequest) {

        return this.customerService.delete(deleteCustomerRequest);
    }
    @GetMapping("/getall")
    public DataResult<List<ListCustomerDto>> getAll(){

        return this.customerService.getAll();
    }

    @GetMapping("/getallpaged")		//hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç tane olsuna göre yapılandırır.
    public DataResult<List<ListCustomerDto>> getAllPaged(int pageNo,int pageSize) {

        return this.customerService.getAllPaged(pageNo, pageSize);
    }

   /* @GetMapping("/getallsorted")//sorted sıralı demek
    public  DataResult<List<ListCustomerDto>> getAllSorted(String option,String fields){

        return this.customerService.getAllSorted(option,fields);
    }*/
}
