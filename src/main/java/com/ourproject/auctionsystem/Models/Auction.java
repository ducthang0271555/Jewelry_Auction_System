package com.ourproject.auctionsystem.Models;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auctionID;

    @Column(name = "startTime", nullable = false)
    private Date startTime;

    @Column(name = "endTime")
    private Date endTime;

    @Column(name = "status", nullable = false)
    private String status;
}