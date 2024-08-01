package com.ourproject.auctionsystem.service;

import com.ourproject.auctionsystem.pojo.User;
import java.util.List;

public interface IUserService {
    void register(User user);
    User login(String username, String password);
    User getUserById(int userId);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int userId);
}
