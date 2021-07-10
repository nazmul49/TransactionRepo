package com.example.demoProject.services;

import com.example.demoProject.models.TransactionRequest;

public interface TransactionService {
    public String doTransaction(TransactionRequest transactionData);
    public void addTransactionRecord(TransactionRequest transactionData);
}
