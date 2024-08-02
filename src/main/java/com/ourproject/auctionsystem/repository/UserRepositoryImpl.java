package com.ourproject.auctionsystem.Repo;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        int index = users.indexOf(getUserById(user.getUserId()));
        if (index >= 0) {
            users.set(index, user);
        }
    }

    @Override
    public void deleteUser(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            users.remove(user);
        }
    }

    @Override
    public User getUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

	@Override
	public User getUserByUsername(String username) {
		
		return null;
	}
}
