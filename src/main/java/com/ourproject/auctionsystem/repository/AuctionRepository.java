package com.ourproject.auctionsystem.Repo;

import java.util.List;

public interface AuctionRepository {
    void createAuction(Auction auction);
    void updateAuction(Auction auction);
    void deleteAuction(int auctionId);
    Auction getAuctionById(int auctionId);
    List<Auction> getAllAuctions();
}
