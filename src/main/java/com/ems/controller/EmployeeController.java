package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.EmployeeDto;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("api/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("create")
	
	public EmployeeDto craeteNewEmployee(@RequestBody EmployeeDto employeeDto)
	{
		return employeeService.createEmploye(employeeDto);
		
	}
	
	@GetMapping
	public List<EmployeeDto> searchAllEmployee()
	{
		return employeeService.findAllEmployees();
	}

}
