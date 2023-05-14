package com.gl.EmployeeManagementRest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.gl.EmployeeManagementRest.dto.UserRegistrationDto;
import com.gl.EmployeeManagementRest.entity.Role;
import com.gl.EmployeeManagementRest.entity.User;
import com.gl.EmployeeManagementRest.repository.UserRepository;
import com.gl.EmployeeManagementRest.security.MyUserDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;

	@Override
	public void save(UserRegistrationDto registrationDto) {
		List<Role> role = registrationDto.getRole();
		User user = new User(registrationDto.getUsername(), bCryptEncoder.encode(registrationDto.getPassword()), role);
		userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Could not find user");
		return new MyUserDetails(user);
	}

}
