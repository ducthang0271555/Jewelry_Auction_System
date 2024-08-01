package com.ourproject.auctionsystem.pojo;

import java.util.Date;

public class TransactionHistory {
    private int transactionID;
    private int auctionID;
    private int jewelryID;
    private Date transactionDate;
    private double transactionAmount;

    // Getters and Setters
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }

    public int getJewelryID() {
        return jewelryID;
    }

    public void setJewelryID(int jewelryID) {
        this.jewelryID = jewelryID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}