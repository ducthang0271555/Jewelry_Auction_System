package com.ourproject.auctionsystem.Models;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;

    @Column(name = "orderID", nullable = false)
    private int orderID;

    @Column(name = "paymentAmount", nullable = false)
    private double paymentAmount;

    @Column(name = "paymentDate", nullable = false)
    private Date paymentDate;
}