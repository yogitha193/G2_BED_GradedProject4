package com.gl.EmployeeManagementRest.dto;

import java.util.List;

import com.gl.EmployeeManagementRest.entity.Role;

public class UserRegistrationDto {

	private String username;
	private String password;
	private List<Role> role;

	public UserRegistrationDto(String username, String password, List<Role> role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public UserRegistrationDto() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

}
