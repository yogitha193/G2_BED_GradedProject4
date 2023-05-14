package com.gl.EmployeeManagementRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gl.EmployeeManagementRest.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	public List<Role> findRoleByName(String name);
}
