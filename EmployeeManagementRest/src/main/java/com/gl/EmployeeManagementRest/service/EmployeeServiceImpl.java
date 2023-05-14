package com.gl.EmployeeManagementRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.EmployeeManagementRest.entity.Employee;
import com.gl.EmployeeManagementRest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id).get();

		if (employee == null)
			throw new RuntimeException("Did not find the employee id: " + id);
		else
			return employee;

	}

	@Override
	public List<Employee> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return employeeRepository.findByKeyword(keyword);
	}

	@Override
	public List<Employee> getByOrder(String order) {
		// TODO Auto-generated method stub

		if (order.equals("ASC")) {
			return employeeRepository.findAllByOrderByFirstnameAsc();
		} else {
			return employeeRepository.findAllByOrderByFirstnameDesc();
		}

	}

}
