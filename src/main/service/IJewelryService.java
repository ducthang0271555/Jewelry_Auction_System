package com.ourproject.auctionsystem.service;

import java.util.List;
import com.ourproject.auctionsystem.pojo.Jewelry;

public interface IJewelryService {
    void updateJewelryInfo(Jewelry jewelry);
    Jewelry getJewelryById(int jewelryId);
    List<Jewelry> getAllJewelries();
    void addJewelry(Jewelry jewelry);
    void deleteJewelry(int jewelryId);
}