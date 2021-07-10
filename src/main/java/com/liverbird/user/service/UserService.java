package com.liverbird.user.service;

import java.util.List;

import com.liverbird.user.service.dto.UserDTO;

public interface UserService {
	
	public List<UserDTO> getAllUsers();

	public UserDTO getUserById(long userId);

	public UserDTO addUser(UserDTO user);

	public UserDTO updateUser(UserDTO user);

	public void deleteUserById(long userId);
}
