package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
