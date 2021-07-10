package com.example.demoProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoProject.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
