package com.example.demoProject.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject.common.Utility;
import com.example.demoProject.constants.Messages;
import com.example.demoProject.models.TransactionRequest;
import com.example.demoProject.services.TransactionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    Utility utility;

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/app/status", method = RequestMethod.GET)
    public String getApplicationStatus() {
        try {
            return Messages.APPLICATION_STATUS_SUCCESS_MSG;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @PostMapping(value = "/transaction", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public String performTransaction(@RequestBody @Valid TransactionRequest transactionRequest) {
        try {
            return transactionService.doTransaction(transactionRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
