package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import javax.validation.Valid;

//dış dünya ile iletişim kurar 
@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	// @Autowired
	public BrandsController(BrandService brandService) {

		this.brandService = brandService;
	}

	// veri tabanı nesnesini controllera taşımak yasak
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {

		return this.brandService.add(createBrandRequest);
	}

	@PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {

		return  this.brandService.update(updateBrandRequest);
    }
	@PostMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteBrandRequest deleteBrandRequest) {

		return  this.brandService.delete(deleteBrandRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ListBrandDto>> getAll() {

		return this.brandService.getAll();
	}
}
//response-request pattern