package com.gl.EmployeeManagementRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.EmployeeManagementRest.entity.Employee;
import com.gl.EmployeeManagementRest.service.EmployeeService;

@RestController
@RequestMapping("/employees")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/*
	 * /view/{id} to view an employee of ID:id /list to display the list of
	 * employees /sort to display the list of employees in Ascending or Descending
	 * order of first name /search/{keyword} to display the list of employees by
	 * searching with first name /save to add an employee to the database
	 * /delete/{employeeId} to delete and employee of ID:employeeId /update to
	 * update and existing employee
	 */

	// http://localhost:8081/employees/view/8
	@GetMapping("/view/{id}") // RequestMapping : view, HttpMethod : Get
	public Employee viewEmployee(@PathVariable("id") int id) {
		Employee viewEmployee = null;
		try {
			viewEmployee = employeeService.findById(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return viewEmployee;

	}

	// http://localhost:8081/employees/list
	@GetMapping("/list") // RequestMapping : list, HttpMethod : Get
	public List<Employee> listEmployees() {

		List<Employee> theEmployees;

		theEmployees = employeeService.findAll();
		return theEmployees;

	}

	// http://localhost:8081/employees/sort?order="ASC"
	@GetMapping("/sort") // RequestMapping : sort, HttpMethod : Get
	public List<Employee> sortbyname(@RequestParam("order") String order) {
		List<Employee> theEmployees = null;

		try {
			if (order != null) {
				if (order.equals("ASC")) {
					theEmployees = employeeService.getByOrder(order);
				}
				if (order.equals("DESC")) {
					theEmployees = employeeService.getByOrder(order);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return theEmployees;
	}

	// http://localhost:8081/employees/search/firstname
	@GetMapping("/search/{keyword}") // RequestMapping : search, HttpMethod : Get
	public List<Employee> searchbyname(@PathVariable String keyword) {
		List<Employee> theEmployees = null;
		try {
			if (keyword != null) {
				theEmployees = employeeService.getByKeyword(keyword);

			} else {
				theEmployees = employeeService.findAll();

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return theEmployees;

	}

	// http://localhost:8081/employees/save
	@PostMapping("/save") // RequestMapping : save, HttpMethod : Post
	public String saveEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return "employee inserted successfully";
	}

	// http://localhost:8081/employees/delete/8
	@DeleteMapping("/delete/{employeeId}") // RequestMapping : delete, HttpMethod : Delete
	public String deleteEmployee(@PathVariable int employeeId) {
		try {
			employeeService.deleteById(employeeId);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "employee id - " + employeeId + " Deleted Successfully";
	}

	// http://localhost:8081/employees/update
	@PutMapping("/update") // RequestMapping : update, HttpMethod : Put
	public Employee showFormForUpdate(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);

		return theEmployee;
	}

}
