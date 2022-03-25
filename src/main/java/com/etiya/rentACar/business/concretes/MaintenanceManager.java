package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.statementRequests.CreateStatementRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.MaintenanceDao;
import com.etiya.rentACar.dataAccess.abstracts.StatementDao;
import com.etiya.rentACar.entities.Maintenance;
import com.etiya.rentACar.entities.Statement;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceManager implements MaintenanceService {

    private  MaintenanceDao maintenanceDao;
    private ModelMapperService modelMapperService;

    public MaintenanceManager(MaintenanceDao maintenanceDao, ModelMapperService modelMapperService) {
        this.maintenanceDao = maintenanceDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void add(CreateMaintenanceRequest createMaintenanceRequest) throws ParseException {
        checkIfCarInMaintenance(createMaintenanceRequest.getCarId());

        setMaintenanceStatement(createMaintenanceRequest);
        checkIfCarAvaliable(createMaintenanceRequest.getDateAdded(), createMaintenanceRequest.getDateReturned(), createMaintenanceRequest.getCarId());
        Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);
        this.maintenanceDao.save(maintenance);

    }

    @Override
    public List<ListMaintenanceDto> getAll() {
        List<Maintenance> maintenances= this.maintenanceDao.findAll();
        List<ListMaintenanceDto> response = maintenances.stream().map(maintenance->this.modelMapperService.forDto().map(maintenance, ListMaintenanceDto.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public List<ListMaintenanceDto> getByCarId(int id) {

        List<Maintenance> maintenances= this.maintenanceDao.findAll();
        List<ListMaintenanceDto> response = maintenances.stream().map(maintenance->this.modelMapperService.forDto().map(maintenance, ListMaintenanceDto.class))
                .filter(x -> x.getCarId() == id)
                .collect(Collectors.toList());
        return response;
    }

    public void checkIfCarInMaintenance(int carId){


        if(maintenanceDao.existsMaintenanceByCarId(carId)){
            throw new RuntimeException("Araba Zaten Bakımda.");
        }

    }

    public void checkIfCarStatement(String dateAdded, String dateReturned, int carId) throws ParseException {
        Date dateToday = getTodayTime();
        SimpleDateFormat formatter2=new SimpleDateFormat("dd.MM.yyyy");
        Date newDateAdded=formatter2.parse(dateAdded);


        SimpleDateFormat formatter3=new SimpleDateFormat("dd.MM.yyyy");
        Date newDateReturned=formatter3.parse(dateReturned);



        if(newDateAdded.before(dateToday) && newDateReturned.after(dateToday)){



        }
        else{
            throw new RuntimeException("Tarihler Uygun Değil.");
        }


    }


  public void checkIfCarAvaliable(String dateAdded, String dateReturned, int carId) throws ParseException {
      if(!maintenanceDao.existsMaintenanceByCarId(carId)){

          checkIfCarStatement( dateAdded,  dateReturned, carId);
      }
      else {
          throw new RuntimeException("Araba Zaten Bakımda.");
      }

  }

    public Date getTodayTime() throws ParseException {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String formattedDate = myDateObj.format(myFormatObj);
        SimpleDateFormat formatter1=new SimpleDateFormat("dd.MM.yyyy");
        Date date1=formatter1.parse(formattedDate);

        return date1;

    }

    public void setMaintenanceStatement(CreateMaintenanceRequest createMaintenanceRequest) throws ParseException {
        Maintenance maintenance = new Maintenance();
        Statement statement = new Statement();
        if(checkForAvailability(createMaintenanceRequest.getDateReturned())){


           // statement.setName(createStatementRequest.getName());

        }

    }


    public boolean checkForAvailability(String dateReturned) throws ParseException {
        SimpleDateFormat formatter1=new SimpleDateFormat("dd.MM.yyyy");
        Date date1=formatter1.parse(dateReturned);

        if(date1.before(getTodayTime())){
            return true;
        }
        else {
            throw new RuntimeException("Araba bakımda.");
        }
    }



}
