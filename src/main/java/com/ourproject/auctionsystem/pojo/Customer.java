package com.ourproject.auctionsystem.pojo;

public class Customer extends User {
    private int customerID;
    private String name;
    private String address;

    // Getters and Setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    // Methods
    public void registerForAuction() {
    }

    public void placeBid() {
    }

    public void makePayment() {
    }

    public void viewAuctionResult() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
