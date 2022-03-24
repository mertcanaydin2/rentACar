package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.entities.Damage;

import java.util.List;

public interface DamageService {
    void add(CreateDamageRequest createDamageRequest);
    List<ListDamageDto> getAll();

    List<ListDamageDto> getByCarId(int id);
    List<ListDamageDto> getAllPaged(int pageNo,int pageSize);
    List<ListDamageDto> getAllSorted(String field,String option);

}
