package com.example.demoProject.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransactionRequest {
    @NotNull
    @NotEmpty(message = "requestId is a required field")
    private String requestId;

    @NotNull
    @NotEmpty(message = "requester is a required field")
    private String requester;

    @NotNull
    @NotEmpty(message = "transactionType is a required field")
    private String transactionType;

    @NotNull
    @NotEmpty(message = "sourceAccountNumber is a required field")
    private String sourceAccountNumber;

    @NotNull
    @NotEmpty(message = "amount is a required field")
    private String amount;

    @NotNull
    @NotEmpty(message = "destinationAccountNumber is a required field")
    private String destinationAccountNumber;

    @NotNull
    @NotEmpty(message = "note is a required field")
    private String note;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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
        return "TransactionRequest [requestId=" + requestId + ", requester=" + requester + ", transactionType="
                + transactionType + ", sourceAccountNumber=" + sourceAccountNumber + ", amount=" + amount
                + ", destinationAccountNumber=" + destinationAccountNumber + ", note=" + note + "]";
    }

}
