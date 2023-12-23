package com.office.laderatechnology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.office.laderatechnology.entity.Department;
import com.office.laderatechnology.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping("/createDepartment")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		Department createdDepartment = departmentService.createDepartment(department);
		return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
	}

	@GetMapping("/allDepartment")
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> departments = departmentService.getAllDepartments();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/department")
	public void deletedepartmentById(@RequestParam Long id) {
		departmentService.deleteDepartmentById(id);
	}
	
	@GetMapping("/department/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}
	
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id,
                                                       @RequestBody Department department) {
        Department updateDepartment = departmentService.updateDepartment(id, department);
        return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
    }
	
}
