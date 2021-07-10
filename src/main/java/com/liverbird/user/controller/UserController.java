package com.liverbird.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liverbird.user.service.UserService;
import com.liverbird.user.service.dto.UserDTO;

@RestController(value = "/user")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET, path = "/get/all")
	public List<UserDTO> getAllUserList() {
		return service.getAllUsers();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/get/{userId}")
	public UserDTO getUserById(@PathVariable final long userId) {
		return service.getUserById(userId);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public UserDTO createUser(@RequestBody final UserDTO user) {
		return service.addUser(user);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/update")
	public UserDTO updateUser(@RequestBody final UserDTO user) {
		return service.updateUser(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/delete/{userId}")
	public void deleteUserById(@PathVariable final long userId) {
		service.deleteUserById(userId);
	}

}
