package com.ourproject.auctionsystem.Models;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "transaction_history")
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID;

    @Column(name = "auctionID", nullable = false)
    private int auctionID;

    @Column(name = "jewelryID", nullable = false)
    private int jewelryID;

    @Column(name = "transactionDate", nullable = false)
    private Date transactionDate;

    @Column(name = "transactionAmount", nullable = false)
    private double transactionAmount;
}