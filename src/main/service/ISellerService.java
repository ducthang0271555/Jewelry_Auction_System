package com.ourproject.auctionsystem.service;

import com.ourproject.auctionsystem.pojo.Seller;
import java.util.List;

public interface ISellerService {
    void submitAuctionRequest(Seller seller);
    void confirmAuction(Seller seller);
    Seller getSellerById(int sellerId);
    List<Seller> getAllSellers();
    void updateSeller(Seller seller);
    void deleteSeller(int sellerId);
}