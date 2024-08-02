package com.ourproject.auctionsystem.Repo;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void createTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        int index = transactions.indexOf(getTransactionById(transaction.getTransactionId()));
        if (index >= 0) {
            transactions.set(index, transaction);
        }
    }

    @Override
    public void deleteTransaction(int transactionId) {
        Transaction transaction = getTransactionById(transactionId);
        if (transaction != null) {
            transactions.remove(transaction);
        }
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        return transactions.stream()
                .filter(transaction -> transaction.getTransactionId() == transactionId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}
