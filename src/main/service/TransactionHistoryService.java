package com.ourproject.auctionsystem.service;

import java.util.ArrayList;
import java.util.List;
import com.ourproject.auctionsystem.pojo.TransactionHistory;

public class TransactionHistoryService implements ITransactionHistoryService {
    private List<TransactionHistory> transactions = new ArrayList<>();

    @Override
    public void logTransaction(TransactionHistory transactionHistory) {
        transactions.add(transactionHistory);
    }

    @Override
    public TransactionHistory getTransactionById(int transactionId) {
        return transactions.stream()
                .filter(transaction -> transaction.getTransactionID() == transactionId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TransactionHistory> getAllTransactions() {
        return new ArrayList<>(transactions);
    }

    @Override
    public void deleteTransaction(int transactionId) {
        transactions.removeIf(transaction -> transaction.getTransactionID() == transactionId);
    }
}
