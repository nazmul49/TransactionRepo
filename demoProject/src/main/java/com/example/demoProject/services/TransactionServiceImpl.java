package com.example.demoProject.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoProject.common.Utility;
import com.example.demoProject.constants.Messages;
import com.example.demoProject.entities.Account;
import com.example.demoProject.entities.Transaction;
import com.example.demoProject.enums.TransactionType;
import com.example.demoProject.models.TransactionRequest;
import com.example.demoProject.repositories.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    Utility utility;

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public synchronized String doTransaction(TransactionRequest transactionData) {
        try {
            // Decode the base64 data to string
            transactionData.setTransactionType(utility.base64ToString(transactionData.getTransactionType()));
            transactionData.setSourceAccountNumber(utility.base64ToString(transactionData.getSourceAccountNumber()));
            transactionData.setAmount(utility.base64ToString(transactionData.getAmount()));
            transactionData
                    .setDestinationAccountNumber(utility.base64ToString(transactionData.getDestinationAccountNumber()));

            // find source and destination accounts by accountNumber
            Account srcAcc = accountService.findByAccountNumber(transactionData.getSourceAccountNumber());
            Account destAcc = accountService.findByAccountNumber(transactionData.getDestinationAccountNumber());

            if (srcAcc == null || destAcc == null) {
                return Messages.INVALID_ACCOUNT_ERROR_MSG;
            }

            if (transactionData.getTransactionType().equals(TransactionType.TRANSFER.name())) {
                double srcAccBalance = Double.valueOf(srcAcc.getBalance());
                double destAccBalance = Double.valueOf(destAcc.getBalance());
                double transferBalance = Double.valueOf(transactionData.getAmount());

                if (srcAccBalance >= transferBalance) {
                    // update source account balance
                    srcAccBalance -= transferBalance;
                    srcAcc.setBalance(String.valueOf(srcAccBalance));
                    accountService.updateAccount(srcAcc);

                    // update destination account balance
                    destAccBalance += transferBalance;
                    destAcc.setBalance(String.valueOf(destAccBalance));
                    accountService.updateAccount(destAcc);

                    // entry in transaction table
                    addTransactionRecord(transactionData);

                    return Messages.TRANSACTION_SUCCESS_MSG;
                } else {
                    return Messages.SOURCE_BALANCE_NOT_SUFFICIENT_ERROR_MSG;
                }
            }

            else if (transactionData.getTransactionType().equals(TransactionType.REVERSE.name())) {
                double srcAccBalance = Double.valueOf(srcAcc.getBalance());
                double destAccBalance = Double.valueOf(destAcc.getBalance());
                double transferBalance = Double.valueOf(transactionData.getAmount());

                if (destAccBalance >= transferBalance) {
                    // update destination account balance
                    destAccBalance -= transferBalance;
                    destAcc.setBalance(String.valueOf(destAccBalance));
                    accountService.updateAccount(destAcc);

                    // update destination account balance
                    srcAccBalance += transferBalance;
                    srcAcc.setBalance(String.valueOf(srcAccBalance));
                    accountService.updateAccount(srcAcc);

                    // entry in transaction table
                    addTransactionRecord(transactionData);

                    return Messages.REVERSE_SUCCESS_MSG;
                } else {
                    return Messages.DESTINATION_BALANCE_NOT_SUFFICIENT_ERROR_MSG;
                }
            }

            return Messages.INVALID_TRANSACTION_TYPE_ERROR_MSG;

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public void addTransactionRecord(TransactionRequest transactionData) {
        Transaction tranObj = new Transaction();

        tranObj.setRequestId(transactionData.getRequestId());
        tranObj.setTransactionTime(new Date().toString());
        tranObj.setRequester(transactionData.getRequester());
        tranObj.setAmount(transactionData.getAmount());
        tranObj.setTransactionType(transactionData.getTransactionType());
        tranObj.setSourceAccountNumber(transactionData.getSourceAccountNumber());
        tranObj.setDestinationAccountNumber(transactionData.getDestinationAccountNumber());
        tranObj.setNote(transactionData.getNote());

        transactionRepository.save(tranObj);
    }

}
