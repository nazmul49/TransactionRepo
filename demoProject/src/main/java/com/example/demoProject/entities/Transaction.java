package com.example.demoProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "requestId is required field")
    @NotNull
    @Column(unique = true)
    private String requestId;

    @NotEmpty(message = "transactionTime is required field")
    @NotNull
    private String transactionTime;

    @NotEmpty(message = "requester is required field")
    @NotNull
    private String requester;

    @NotEmpty(message = "transactionType is required field")
    @NotNull
    private String transactionType;

    @NotEmpty(message = "sourceAccountNumber is required field")
    @NotNull
    private String sourceAccountNumber;

    @NotEmpty(message = "amount is required field")
    @NotNull
    private String amount;

    @NotEmpty(message = "destinationAccountNumber is required field")
    @NotNull
    private String destinationAccountNumber;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", requestId=" + requestId + ", transactionTime=" + transactionTime
                + ", requester=" + requester + ", transactionType=" + transactionType + ", sourceAccountNumber="
                + sourceAccountNumber + ", amount=" + amount + ", destinationAccountNumber=" + destinationAccountNumber
                + ", note=" + note + "]";
    }
}
