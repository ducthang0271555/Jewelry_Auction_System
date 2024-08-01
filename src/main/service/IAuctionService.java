package com.ourproject.auctionsystem.service;

import java.util.List;
import com.ourproject.auctionsystem.pojo.Auction;

public interface IAuctionService {
    void createAuction(Auction auction);
    void openAuction(Auction auction);
    void closeAuction(Auction auction);
    void addJewelry(Auction auction, int jewelryId);
    Auction getAuctionById(int auctionId);
    List<Auction> getAllAuctions();
    void updateAuction(Auction auction);
    void deleteAuction(int auctionId);
}