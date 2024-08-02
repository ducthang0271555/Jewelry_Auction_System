package com.ourproject.auctionsystem.Models;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "jewelry")
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jewelryID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "initialPrice", nullable = false)
    private double initialPrice;

    @Column(name = "finalPrice")
    private double finalPrice;

    @Column(name = "status", nullable = false)
    private String status;

    public void setJewelryId(int jewelryID) {
        this.jewelryID = jewelryID;
    }
    public int getJewelryId(){
        return jewelryID;
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