package com.ourproject.auctionsystem.Repo;

import java.util.ArrayList;
import java.util.List;

public class JewelryRepositoryImpl implements JewelryRepository {
    private List<Jewelry> jewelries = new ArrayList<>();

    @Override
    public void createJewelry(Jewelry jewelry) {
        jewelries.add(jewelry);
    }

    @Override
    public void updateJewelry(Jewelry jewelry) {
        int index = jewelries.indexOf(getJewelryById(jewelry.getJewelryId()));
        if (index >= 0) {
            jewelries.set(index, jewelry);
        }
    }

    @Override
    public void deleteJewelry(int jewelryId) {
        Jewelry jewelry = getJewelryById(jewelryId);
        if (jewelry != null) {
            jewelries.remove(jewelry);
        }
    }

    @Override
    public Jewelry getJewelryById(int jewelryId) {
        return jewelries.stream()
                .filter(jewelry -> jewelry.getJewelryId() == jewelryId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Jewelry> getAllJewelry() {
        return new ArrayList<>(jewelries);
    }
}
