package com.liverbird.user.repository;

import java.util.List;

import com.liverbird.user.entity.User;

public interface UserRepo {

	public List<User> getAllUsers();
	public User getUserById(long userId);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUserById(long userId);
}
