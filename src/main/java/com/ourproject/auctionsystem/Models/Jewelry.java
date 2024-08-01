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
}