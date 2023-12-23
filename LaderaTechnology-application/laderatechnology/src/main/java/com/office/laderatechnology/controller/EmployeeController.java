package com.office.laderatechnology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.office.laderatechnology.entity.Employee;
import com.office.laderatechnology.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
//
//	@GetMapping("/expenses/{id}")
//	public Expense getExpenseById(@PathVariable Long id) {
//		return expenseService.getExpenseById(id);
//	}

	@GetMapping("/getEmployee/{employeeId}")
	public Employee getEmployeeById(@PathVariable String employeeId) {
		return employeeService.getEmployeeId(employeeId);
	}
//	@PutMapping("/updateEmployee/{id}")
//	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
//		// return expenseService.updateExpenseDetails(id, expense);
//		return employeeService.updateEmployee(id, updatedEmployee);
//		// Employee updated = employeeService.updateEmployee(id, updatedEmployee);
//		// return ResponseEntity.ok(updated);
//	}
//
//	@GetMapping("/showEmployee/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable Employee employeeId) {
//		return employeeService.getEmployeeById(employeeId).map(ResponseEntity::ok)
//				.orElse(ResponseEntity.notFound().build());
//
//	}
	}

