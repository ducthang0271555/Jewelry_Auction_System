package com.ourproject.auctionsystem.Repo;
import java.util.List;

public interface BidRepository {
    void createBid(Bid bid);
    void updateBid(Bid bid);
    void deleteBid(int bidId);
    Bid getBidById(int bidId);
    List<Bid> getAllBids();
}
