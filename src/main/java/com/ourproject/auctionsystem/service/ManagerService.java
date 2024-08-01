package com.ourproject.auctionsystem.service;

import java.util.ArrayList;
import java.util.List;
import com.ourproject.auctionsystem.pojo.Manager;

public class ManagerService implements IManagerService {
    private List<Manager> managers = new ArrayList<>();

    @Override
    public void approveValuation(Manager manager) {
        // Thực hiện logic phê duyệt định giá ở đây
    }

    @Override
    public void assignAuction(Manager manager) {
        // Thực hiện logic phân công đấu giá ở đây
    }

    @Override
    public Manager getManagerById(int managerId) {
        return managers.stream()
                .filter(manager -> manager.getManagerID() == managerId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Manager> getAllManagers() {
        return new ArrayList<>(managers);
    }

    @Override
    public void updateManager(Manager manager) {
        int index = managers.indexOf(getManagerById(manager.getManagerID()));
        if (index != -1) {
            managers.set(index, manager);
        }
    }

    @Override
    public void deleteManager(int managerId) {
        managers.removeIf(manager -> manager.getManagerID() == managerId);
    }
}
