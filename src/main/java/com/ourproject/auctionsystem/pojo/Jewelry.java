package com.ourproject.auctionsystem.pojo;

public class Jewelry {
    private int jewelryID;
    private String name;
    private String description;
    private double initialPrice;
    private double finalPrice;
    private String status;

    // Getters and Setters
    public int getJewelryID() {
        return jewelryID;
    }

    public void setJewelryID(int jewelryID) {
        this.jewelryID = jewelryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}