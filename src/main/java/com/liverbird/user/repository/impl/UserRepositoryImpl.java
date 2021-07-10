package com.liverbird.user.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.liverbird.user.entity.User;
import com.liverbird.user.repository.UserRepo;

@Repository
public class UserRepositoryImpl implements UserRepo {

	private List<User> userList = new ArrayList<>();

	@Override
	public List<User> getAllUsers() {
		return this.userList;
	}

	@Override
	public User getUserById(long userId) {
		Optional<User> user = userList.stream().filter(us -> us.getUserId() == userId).findAny();
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public void addUser(User user) {
		userList.add(user);
	}

	@Override
	public void updateUser(User user) {
		userList.forEach(us -> {
			if (us.getUserId() == user.getUserId()) {
				us.setName(user.getName());
				us.setEmail(user.getEmail());
				us.setCountry(user.getCountry());
			}
		});
	}

	@Override
	public void deleteUserById(long userId) {
		userList.removeIf(us -> us.getUserId() == userId);
	}

}
