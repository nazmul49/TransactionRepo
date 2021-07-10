package com.example.demoProject.services;

import com.example.demoProject.entities.Account;

public interface AccountService {
    public Account findByAccountNumber(String accountNumber);
    public void updateAccount(Account acc);
}
