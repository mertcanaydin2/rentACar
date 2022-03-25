package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.entities.Color;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.dataAccess.abstracts.BrandDao;
import com.etiya.rentACar.entities.Brand;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service // BrandManager'ın servis katmanı olduğunu belirtiyoruz
public class BrandManager implements BrandService {
    private BrandDao brandDao;
    private ModelMapperService modelMapperService;

    public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
        super();
        this.brandDao = brandDao;
        this.modelMapperService = modelMapperService;
    }

  /*  @Override
    public void add(CreateBrandRequest createBrandRequest) {
        createBrandRequest.setName(createBrandRequest.getName().toLowerCase());
        if (!(brandDao.existsBrandByName(createBrandRequest.getName().toLowerCase()))) {
            Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
            this.brandDao.save(brand);
        }
        else{
            throw new RuntimeException("Bu marka daha önce kaydedilmiş");
        }
    }*/

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        String brandName = createBrandRequest.getName().toLowerCase(Locale.ROOT);
        checkIfBrandExists(brandName);
        createBrandRequest.setName(brandName);

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandDao.save(brand);
    }

    @Override
    public List<ListBrandDto> getAll() {
        List<Brand> brands = this.brandDao.findAll();
        List<ListBrandDto> response = brands.stream()
                .map(brand -> this.modelMapperService.forDto()
                        .map(brand, ListBrandDto.class))
                .collect(Collectors.toList());
        return response;
    }

    private void checkIfBrandExists(String brandName){
        if(brandDao.existsBrandByName(brandName)){
            throw new RuntimeException("Bu renk daha önce kaydedilmiştir. ");
        }
    }


}
