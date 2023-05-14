package com.gl.EmployeeManagementRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.EmployeeManagementRest.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Query to get records where first name matches with the keyword
	@Query(value = "select * from employee e where e.first_name like %:keyword%", nativeQuery = true)
	List<Employee> findByKeyword(@Param("keyword") String keyword);

	// Query to get the records ordered by first name in ascending order
	@Query(value = "select * from employee e order by e.first_name asc ", nativeQuery = true)
	List<Employee> findAllByOrderByFirstnameAsc();

	// Query to get the records ordered by first name in descending order
	@Query(value = "select * from employee e order by e.first_name desc ", nativeQuery = true)
	List<Employee> findAllByOrderByFirstnameDesc();

}
