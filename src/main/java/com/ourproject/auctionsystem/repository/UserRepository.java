package com.ourproject.auctionsystem.Repo;
import java.util.List;
public interface UserRepository {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    User getUserById(int userId);
    List<User> getAllUsers();
    User getUserByUsername(String username);
}
