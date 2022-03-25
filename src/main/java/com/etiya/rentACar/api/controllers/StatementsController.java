package com.etiya.rentACar.api.controllers;


import com.etiya.rentACar.business.abstracts.StatementService;
import com.etiya.rentACar.business.requests.statementRequests.CreateStatementRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statements")
public class StatementsController {

    private StatementService statementService;

    public StatementsController(StatementService statementService) {
        this.statementService = statementService;
    }


    public void add(@RequestBody CreateStatementRequest createStatementRequest){
        this.statementService.add(createStatementRequest);

    }
}
