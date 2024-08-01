package com.ourproject.auctionsystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private int sellerID;
}