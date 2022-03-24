package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.entities.Brand;

import java.util.List;

public interface BrandService {
	void add(CreateBrandRequest createBrandRequest);
	List<ListBrandDto> getAll();
}
