package com.ourproject.auctionsystem.Repo;

import java.util.ArrayList;
import java.util.List;

public class BidRepositoryImpl implements BidRepository {
    private List<Bid> bids = new ArrayList<>();

    @Override
    public void createBid(Bid bid) {
        bids.add(bid);
    }

    @Override
    public void updateBid(Bid bid) {
        int index = bids.indexOf(getBidById(bid.getBidId()));
        if (index >= 0) {
            bids.set(index, bid);
        }
    }

    @Override
    public void deleteBid(int bidId) {
        Bid bid = getBidById(bidId);
        if (bid != null) {
            bids.remove(bid);
        }
    }

    @Override
    public Bid getBidById(int bidId) {
        return bids.stream()
                .filter(bid -> bid.getBidId() == bidId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Bid> getAllBids() {
        return new ArrayList<>(bids);
    }
}
