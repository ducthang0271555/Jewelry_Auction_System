package com.ourproject.auctionsystem.service;

import java.util.ArrayList;
import java.util.List;
import com.ourproject.auctionsystem.pojo.Auction;

public class AuctionService implements IAuctionService {
    private List<Auction> auctions = new ArrayList<>();

    @Override
    public void createAuction(Auction auction) {
        auctions.add(auction);
    }

    @Override
    public void openAuction(Auction auction) {
        auction.setStatus("Open");
    }

    @Override
    public void closeAuction(Auction auction) {
        auction.setStatus("Closed");
    }

    @Override
    public void addJewelry(Auction auction, int jewelryId) {
        // Implement adding jewelry logic here
    }

    @Override
    public Auction getAuctionById(int auctionId) {
        return auctions.stream()
                .filter(auction -> auction.getAuctionID() == auctionId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Auction> getAllAuctions() {
        return new ArrayList<>(auctions);
    }

    @Override
    public void updateAuction(Auction auction) {
        int index = auctions.indexOf(getAuctionById(auction.getAuctionID()));
        if (index != -1) {
            auctions.set(index, auction);
        }
    }

    @Override
    public void deleteAuction(int auctionId) {
        auctions.removeIf(auction -> auction.getAuctionID() == auctionId);
    }
}
