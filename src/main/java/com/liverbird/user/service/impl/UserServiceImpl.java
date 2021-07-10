package com.liverbird.user.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liverbird.user.entity.User;
import com.liverbird.user.repository.UserRepo;
import com.liverbird.user.service.UserService;
import com.liverbird.user.service.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> userList = userRepo.getAllUsers();
		if (userList != null) {
			return userList.stream().map(UserDTO::convertEntityToDTO).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
	public UserDTO getUserById(long userId) {
		User entity = userRepo.getUserById(userId);
		if (entity != null) {
			return UserDTO.convertEntityToDTO(entity);
		}
		return null;
	}

	@Override
	public UserDTO addUser(UserDTO user) {
		User entity = userRepo.getUserById(user.getUserId());
		if (null == entity) {
			userRepo.addUser(UserDTO.convertDtoToEntity(user));
		}
		return getUserById(user.getUserId());
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		User entity = userRepo.getUserById(user.getUserId());
		if(null != entity) {
			userRepo.updateUser(UserDTO.convertDtoToEntity(user));
		} else {
			addUser(user);
		}
		return getUserById(user.getUserId());
	}

	@Override
	public void deleteUserById(long userId) {
		userRepo.deleteUserById(userId);
	}
}
