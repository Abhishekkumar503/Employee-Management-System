package com.ems.service;

import java.util.List;

import com.ems.dto.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto createEmploye (EmployeeDto employeeDto);

	public List<EmployeeDto> findAllEmployees();
}
