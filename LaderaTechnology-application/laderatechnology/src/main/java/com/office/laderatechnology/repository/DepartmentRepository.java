package com.office.laderatechnology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.office.laderatechnology.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
