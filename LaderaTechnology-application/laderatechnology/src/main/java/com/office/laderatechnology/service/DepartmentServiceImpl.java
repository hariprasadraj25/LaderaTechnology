package com.office.laderatechnology.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.laderatechnology.entity.Department;
import com.office.laderatechnology.repository.DepartmentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
	}
	
	@Override
	public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

	public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
    }

    public Department updateDepartment(Long id, Department department) {
        Department existingDepartment = getDepartmentById(id);
        existingDepartment.setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(existingDepartment);
    }

}
