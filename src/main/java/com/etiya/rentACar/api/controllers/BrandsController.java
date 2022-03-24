package com.etiya.rentACar.api.controllers;


import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;

import org.springframework.web.bind.annotation.*;

import com.etiya.rentACar.business.abstracts.BrandService;


import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

	private BrandService brandService; // burada somut nesne brandService'tir. O nedenle bu nesne autowired ile newlenir.

	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService; 
	}
	@PostMapping("/add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}

	@GetMapping("/getall")
	public List<ListBrandDto> getAll(){
		return this.brandService.getAll();
	}

}


//controllerde veritabanı nesnesi olmamalı (brand). Bu nedenle response-request pattern kullanılır