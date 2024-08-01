package com.ourproject.auctionsystem.service;

import java.util.ArrayList;
import java.util.List;
import com.ourproject.auctionsystem.pojo.Jewelry;

public class JewelryService implements IJewelryService {
    private List<Jewelry> jewelries = new ArrayList<>();

    @Override
    public void updateJewelryInfo(Jewelry jewelry) {
        int index = jewelries.indexOf(getJewelryById(jewelry.getJewelryID()));
        if (index != -1) {
            jewelries.set(index, jewelry);
        }
    }

    @Override
    public Jewelry getJewelryById(int jewelryId) {
        return jewelries.stream()
                .filter(jewelry -> jewelry.getJewelryID() == jewelryId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Jewelry> getAllJewelries() {
        return new ArrayList<>(jewelries);
    }

    @Override
    public void addJewelry(Jewelry jewelry) {
        jewelries.add(jewelry);
    }

    @Override
    public void deleteJewelry(int jewelryId) {
        jewelries.removeIf(jewelry -> jewelry.getJewelryID() == jewelryId);
    }
}
