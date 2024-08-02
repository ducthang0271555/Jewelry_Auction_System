package com.ourproject.auctionsystem.pojo;
import java.util.Date;

import java.util.Date;

public class TransactionHistory {
    private int transactionId;
    private int userId;
    private int itemId;
    private Date transactionDate;
    private double amount;

    // Constructor
    public TransactionHistory() {}

    // Getter and Setter for transactionId
    public int getTransactionID() {
        return transactionId;
    }

    public void setTransactionID(int transactionId) {
        this.transactionId = transactionId;
    }

    // Getter and Setter for userId
    public int getUserID() {
        return userId;
    }

    public void setUserID(int userId) {
        this.userId = userId;
    }

    // Getter and Setter for itemId
    public int getItemID() {
        return itemId;
    }

    public void setItemID(int itemId) {
        this.itemId = itemId;
    }

    // Getter and Setter for transactionDate
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Getter and Setter for amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

