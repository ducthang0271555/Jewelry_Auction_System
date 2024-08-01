package com.ourproject.auctionsystem.Models;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @Column(name = "customerID", nullable = false)
    private int customerID;

    @Column(name = "auctionID", nullable = false)
    private int auctionID;

    @Column(name = "orderStatus", nullable = false)
    private String orderStatus;
}