package com.ourproject.auctionsystem.Repo;

import java.util.List;

public interface JewelryRepository {
    void createJewelry(Jewelry jewelry);
    void updateJewelry(Jewelry jewelry);
    void deleteJewelry(int jewelryId);
    Jewelry getJewelryById(int jewelryId);
    List<Jewelry> getAllJewelry();
}
