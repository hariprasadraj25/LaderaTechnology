package com.office.laderatechnology.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.office.laderatechnology.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee getEmployeeById(Employee employeeId);
	
	//Optional<Employee> findByEmployeeIdAndId(Long id, String employeeId);

	Optional<Employee> findByUserId(Employee employeeId);
	
}
