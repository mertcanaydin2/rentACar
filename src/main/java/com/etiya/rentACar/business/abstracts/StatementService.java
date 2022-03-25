package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.statementRequests.CreateStatementRequest;
import com.etiya.rentACar.business.responses.statementResponses.ListStatementDto;

import java.util.List;

public interface StatementService {

    void add (CreateStatementRequest createStatementRequest);
    List<ListStatementDto> getAll();
}
