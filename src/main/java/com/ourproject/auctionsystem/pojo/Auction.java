package com.ourproject.auctionsystem.pojo;
import java.util.Date;

public class Auction {
    private int auctionID;
    private Date startTime;
    private Date endTime;
    private String status;

    // Getters and Setters
    public int getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Methods
    public void createAuction() {
        // Method implementation
    }

    public void openAuction() {
        // Method implementation
    }

    public void closeAuction() {
        // Method implementation
    }

    public void addJewelry() {
        // Method implementation
    }
}

