package com.gl.EmployeeManagementRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.EmployeeManagementRest.dto.UserRegistrationDto;
import com.gl.EmployeeManagementRest.entity.Role;
import com.gl.EmployeeManagementRest.service.RoleService;
import com.gl.EmployeeManagementRest.service.UserService;

@RestController
@RequestMapping("")
public class UserRegistrationController {

	// @Autowired
	private UserService userService;

	/*
	 * /registration/save to add a user to the database 
	 * /roles/save to add roles to the database
	 * 
	 */

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@Autowired
	RoleService roleService;

	// http://localhost:8081/registration/save
	@PostMapping("/registration/save") // RequestMapping : registration/save , HttpMethod : Post
	public String registerUserAccount(@RequestBody UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "user inserted successfully";

	}

	// http://localhost:8081/roles/save
	@PostMapping("/roles/save") // RequestMapping : roles/save, HttpMethod : Post
	public String saveRole(@RequestBody Role theRole) {
		roleService.save(theRole);
		return "role inserted successfully";
	}

}
