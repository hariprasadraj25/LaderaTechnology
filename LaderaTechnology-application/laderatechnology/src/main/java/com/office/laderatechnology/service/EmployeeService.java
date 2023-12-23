package com.office.laderatechnology.service;

import com.office.laderatechnology.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee getEmployeeId(String employeeId);
}
