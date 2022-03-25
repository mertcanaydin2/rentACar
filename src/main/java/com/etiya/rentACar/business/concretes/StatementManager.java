package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.StatementService;
import com.etiya.rentACar.business.requests.statementRequests.CreateStatementRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.business.responses.statementResponses.ListStatementDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.StatementDao;
import com.etiya.rentACar.entities.Maintenance;
import com.etiya.rentACar.entities.Statement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatementManager implements StatementService {

    private ModelMapperService modelMapperService;
    private StatementDao statementDao;


    @Override
    public void add(CreateStatementRequest createStatementRequest) {
        Statement statement = this.modelMapperService.forRequest().map(createStatementRequest, Statement.class);
        this.statementDao.save(statement);
    }

    @Override
    public List<ListStatementDto> getAll() {

        List<Statement> statements= this.statementDao.findAll();
        List<ListStatementDto> response = statements.stream().map(statement->this.modelMapperService.forDto().map(statement, ListStatementDto.class)).collect(Collectors.toList());
        return response;
    }
}
