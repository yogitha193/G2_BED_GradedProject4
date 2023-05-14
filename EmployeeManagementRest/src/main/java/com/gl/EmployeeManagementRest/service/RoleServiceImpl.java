package com.gl.EmployeeManagementRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.EmployeeManagementRest.entity.Role;
import com.gl.EmployeeManagementRest.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void save(Role theRole) {
		// TODO Auto-generated method stub
		roleRepository.save(theRole);
	}

}
