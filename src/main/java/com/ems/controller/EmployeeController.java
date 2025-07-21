package com.ems.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.EmployeeDto;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("api/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("create")
	public ResponseEntity<EmployeeDto> craeteNewEmployee(@RequestBody EmployeeDto employeeDto)
	{
		return new ResponseEntity<>(employeeService.createEmploye(employeeDto), HttpStatus.CREATED) ;
		
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> searchAllEmployee()
	{
		return new ResponseEntity<>(employeeService.findAllEmployees(),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long empId)
	{
		return new ResponseEntity<>(employeeService.deleteEmployeebyId(empId),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") long empId)
	{
		return new ResponseEntity<EmployeeDto>(employeeService.findByEmpId(empId),HttpStatus.OK);
		
	}
	
	@PutMapping("update")
	public ResponseEntity<EmployeeDto> updateEmployeeDetails(@RequestBody EmployeeDto employeeDto)
	{
		return new ResponseEntity<>(employeeService.updateEmployeeDetails(employeeDto), HttpStatus.CREATED) ;
		
	}

}
