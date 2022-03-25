package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;

import java.text.ParseException;
import java.util.List;

public interface MaintenanceService {

    void add(CreateMaintenanceRequest createMaintenanceRequest) throws ParseException;


    List<ListMaintenanceDto> getAll();

}
