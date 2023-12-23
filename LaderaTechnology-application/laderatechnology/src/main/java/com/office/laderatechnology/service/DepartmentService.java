package com.office.laderatechnology.service;

import java.util.List;

import com.office.laderatechnology.entity.Department;

public interface DepartmentService {

	Department createDepartment(Department department);
	
	List<Department> getAllDepartments();
	
	void deleteDepartmentById(Long id);
	
	Department getDepartmentById(Long id);
	
	Department updateDepartment(Long id, Department department);
	
}
