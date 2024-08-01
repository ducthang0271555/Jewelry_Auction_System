package com.ourproject.auctionsystem.Models;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeID;
}