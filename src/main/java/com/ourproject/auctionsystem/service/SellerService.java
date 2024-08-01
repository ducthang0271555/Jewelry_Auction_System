package com.ourproject.auctionsystem.service;

import com.ourproject.auctionsystem.pojo.Seller;
import com.ourproject.auctionsystem.service.ISellerService;
import jakarta.persistence.*;
import java.util.List;
public class SellerService implements ISellerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void submitAuctionRequest(Seller seller) {
        Seller existingSeller = entityManager.find(Seller.class, seller.getSellerID());
        if (existingSeller != null) {
            // Logic to submit auction request (implementation details would depend on the auction request process)
            entityManager.merge(existingSeller);
        } else {
            entityManager.persist(seller);
        }
    }

    @Override
    public void confirmAuction(Seller seller) {
        Seller existingSeller = entityManager.find(Seller.class, seller.getSellerID());
        if (existingSeller != null) {
            // Logic to confirm auction (implementation details would depend on the auction confirmation process)
            entityManager.merge(existingSeller);
        }
    }

    @Override
    public Seller getSellerById(int sellerId) {
        return entityManager.find(Seller.class, sellerId);
    }

    @Override
    public List<Seller> getAllSellers() {
        TypedQuery<Seller> query = entityManager.createQuery("SELECT s FROM Seller s", Seller.class);
        return query.getResultList();
    }

    @Override
    public void updateSeller(Seller seller) {
        entityManager.merge(seller);
    }

    @Override
    public void deleteSeller(int sellerId) {
        Seller seller = entityManager.find(Seller.class, sellerId);
        if (seller != null) {
            entityManager.remove(seller);
        }
    }
}
