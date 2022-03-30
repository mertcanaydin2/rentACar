package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.BrandDao;
import com.etiya.rentACar.entities.Brand;

@Service
public class BrandManager implements BrandService {

	private BrandDao brandDao;
	private ModelMapperService modelMapperService;

	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateBrandRequest createBrandRequest) {

		checkIfIsBrandName(createBrandRequest.getBrandName());
		
		Brand brand = this.modelMapperService.forRequest()
				.map(createBrandRequest, Brand.class);

		this.brandDao.save(brand);
		return new SuccessResult("BRAND_ADDED");
	}
	@Override
    public Result update(UpdateBrandRequest updateBrandRequest) {

        Brand brand = this.modelMapperService.forRequest()
        .map(updateBrandRequest,Brand.class);
        
        this.brandDao.save(brand);
		return new SuccessResult("BRAND_UPDATED");

    }
	

    @Override
    public Result delete(DeleteBrandRequest deleteBrandRequest) {
		this.brandDao.deleteById(deleteBrandRequest.getBrandId());	
		return new SuccessResult("BRAND_DELETED");

    }

	@Override
	public DataResult<List<ListBrandDto>> getAll() {

		List<Brand> brands = this.brandDao.findAll();

		List<ListBrandDto> response = brands.stream()

				.map(brand -> this.modelMapperService.forDto()
				.map(brand, ListBrandDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListBrandDto>>(response);
	}

	public void checkIfIsBrandName(String brandName) {

		if (brandDao.existsBrandByNameIgnoreCase(brandName)) {

			throw new RuntimeException("Bu marka daha önce kaydedilmiştir :/");
		}
	}

}
