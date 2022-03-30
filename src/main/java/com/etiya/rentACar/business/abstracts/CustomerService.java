package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.business.responses.customerResponses.ListCustomerDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface CustomerService {


    DataResult<List<ListCustomerDto>> getAll();
    DataResult<List<ListCustomerDto>> getAllPaged(int pageNo, int pageSize); // hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç tane olsuna göre yapılandırır.
  //  DataResult<List<ListCustomerDto>> getAllSorted(String option, String fields); // sorted sıralı demektir.




    Result add(CreateCustomerRequest createCustomerRequest);
    Result update(UpdateCustomerRequest updateCustomerRequest);
    Result delete(DeleteCustomerRequest deleteCustomerRequest);
}
