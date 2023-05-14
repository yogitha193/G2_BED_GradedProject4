package com.gl.EmployeeManagementRest.service;

import java.util.List;

import com.gl.EmployeeManagementRest.entity.Employee;

public interface EmployeeService {

	// view all employees
	public List<Employee> findAll();

	// insert or update an employee
	public void save(Employee theEmployee);

	// delete an employee
	public void deleteById(int id);

	// to get the employee by id
	public Employee findById(int id);

	// to search employee by keyword
	List<Employee> getByKeyword(String keyword);

	// to sort the employees list in ASC/DESC
	List<Employee> getByOrder(String order);
}
