package com.gl.EmployeeManagementRest.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gl.EmployeeManagementRest.dto.UserRegistrationDto;
//import com.gl.EmployeeManagementRest.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	void save(UserRegistrationDto registrationDto);
}
