package com.office.laderatechnology.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.laderatechnology.entity.Employee;
import com.office.laderatechnology.exception.ResourceNotFoundException;
import com.office.laderatechnology.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeId(String employeeId) {
		Optional<Employee> employee = employeeRepository.findByUserId(employeeService.getEmployeeId(employeeId));
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new ResourceNotFoundException("Employee id does not exists " + employeeId);
	}

		
	
//	@Override
//	public Employee updateEmployee(Long id, Employee updatedEmployee) {
//        Employee existingEmployee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ItemNotFoundException("Employee not found with id: " + id));
//
//        existingEmployee.setAddress(updatedEmployee.getAddress());
//        existingEmployee.setAge(updatedEmployee.getAge());
//        existingEmployee.setAnnualSalary(updatedEmployee.getAnnualSalary());
//        existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
//        existingEmployee.setDesignation(updatedEmployee.getDesignation());
//        existingEmployee.setEmail(updatedEmployee.getEmail());
//        existingEmployee.setEmployeeId(updatedEmployee.getEmployeeId());
//        existingEmployee.setFatherName(updatedEmployee.getFatherName());
//        existingEmployee.setFirstName(updatedEmployee.getFirstName());
//        existingEmployee.setGender(updatedEmployee.getGender());
//        existingEmployee.setId(updatedEmployee.getId());
//        existingEmployee.setJoining(updatedEmployee.getJoining());
//        existingEmployee.setLastName(updatedEmployee.getLastName());
//        existingEmployee.setLeaveBalance(updatedEmployee.getLeaveBalance());
//        existingEmployee.setMobileNumber(updatedEmployee.getMobileNumber());
//        existingEmployee.setMonthlySalary(updatedEmployee.getMonthlySalary());
//        existingEmployee.setPanNumber(updatedEmployee.getPanNumber());
//        existingEmployee.setPfAccountNo(updatedEmployee.getPfAccountNo());
//        existingEmployee.setUanNumber(updatedEmployee.getUanNumber());
//        existingEmployee.setWorkLocation(updatedEmployee.getWorkLocation());
//
//        return employeeRepository.save(existingEmployee);
//    }

	

//	@Override
//	public Employee readEmployee() {
//		Employee employeeId = null;
//		Employee employee = employeeRepository.findByEmployeeId(employee);
//		return employee;
//	}
//	
//	public Optional<Employee> getEmployeeById(Long id) {
//        return employeeRepository.findById(id);
//    }

	

	

}
