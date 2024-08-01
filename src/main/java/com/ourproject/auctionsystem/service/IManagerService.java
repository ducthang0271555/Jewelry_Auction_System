package com.ourproject.auctionsystem.service;

import java.util.List;
import com.ourproject.auctionsystem.pojo.Manager;

public interface IManagerService {
    void approveValuation(Manager manager);
    void assignAuction(Manager manager);
    Manager getManagerById(int managerId);
    List<Manager> getAllManagers();
    void updateManager(Manager manager);
    void deleteManager(int managerId);
}