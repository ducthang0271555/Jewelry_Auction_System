package com.ourproject.auctionsystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "managers")
public class Manager extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private int managerID;
}