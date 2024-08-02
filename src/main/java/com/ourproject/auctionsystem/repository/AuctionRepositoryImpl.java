package com.ourproject.auctionsystem.Repo;

import java.util.ArrayList;
import java.util.List;

public class AuctionRepositoryImpl implements AuctionRepository {
    private List<Auction> auctions = new ArrayList<>();

    @Override
    public void createAuction(Auction auction) {
        auctions.add(auction);
    }

    @Override
    public void updateAuction(Auction auction) {
        int index = auctions.indexOf(getAuctionById(auction.getAuctionId()));
        if (index >= 0) {
            auctions.set(index, auction);
        }
    }

    @Override
    public void deleteAuction(int auctionId) {
        Auction auction = getAuctionById(auctionId);
        if (auction != null) {
            auctions.remove(auction);
        }
    }

    @Override
    public Auction getAuctionById(int auctionId) {
        return auctions.stream()
                .filter(auction -> auction.getAuctionId() == auctionId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Auction> getAllAuctions() {
        return new ArrayList<>(auctions);
    }
}
