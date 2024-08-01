package com.ourproject.auctionsystem.service;

import java.util.List;
import com.ourproject.auctionsystem.pojo.TransactionHistory;

public interface ITransactionHistoryService {
    void logTransaction(TransactionHistory transactionHistory);
    TransactionHistory getTransactionById(int transactionId);
    List<TransactionHistory> getAllTransactions();
    void deleteTransaction(int transactionId);
}