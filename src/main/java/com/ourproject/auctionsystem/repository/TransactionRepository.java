package com.ourproject.auctionsystem.Repo;
import java.util.List;

public interface TransactionRepository {
    void createTransaction(Transaction transaction);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int transactionId);
    Transaction getTransactionById(int transactionId);
    List<Transaction> getAllTransactions();
}
