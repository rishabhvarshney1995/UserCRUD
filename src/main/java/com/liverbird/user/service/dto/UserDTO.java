package com.liverbird.user.service.dto;

import com.liverbird.user.entity.User;

public class UserDTO {

	private Long userId;
	private String name;
	private String email;
	private String country;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserDTO(Long userId, String name, String email, String country) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.country = country;
	}

	public UserDTO() {
		super();
	}

	public static UserDTO convertEntityToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setUserId(user.getUserId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setCountry(user.getCountry());
		return dto;
	}

	public static User convertDtoToEntity(UserDTO dto) {
		User user = new User();
		user.setUserId(dto.getUserId());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setCountry(dto.getCountry());
		return user;
	}

}
