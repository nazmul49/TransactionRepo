package com.example.demoProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoProject.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    public Account findByAccountNumber(String accountNumber);
}
