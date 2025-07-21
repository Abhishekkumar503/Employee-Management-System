package com.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import com.ems.exception.ResouceNotFoundException;
import com.ems.repository.EmployeeRepo;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmploye(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		return modelMapper.map(employeeRepo.save(modelMapper.map(employeeDto, Employee.class)), EmployeeDto.class) ;
	}

	@Override
	public List<EmployeeDto> findAllEmployees() {
		// TODO Auto-generated method stub
//		return List<ModelMapper.map(employeeRepo.findAll(),EmployeeDto.class)>;
		return employeeRepo.findAll().stream().map((Employee) -> modelMapper.map(Employee, EmployeeDto.class)).collect(Collectors.toList());
	}

	@Override
	public String deleteEmployeebyId(long empId) {
		// TODO Auto-generated method 
		employeeRepo.deleteById(empId);
		return "Employee Record delected Successfully";
	}

	@Override
	public EmployeeDto findByEmpId(long empId) {
		// TODO Auto-generated method stub
		return modelMapper.map(employeeRepo.findById(empId).orElseThrow(() -> new ResouceNotFoundException("Employee not exist with given Id : " + empId))
				, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployeeDetails(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		
	Employee employee =	employeeRepo.findById(employeeDto.getId()).orElseThrow(() ->
	new ResouceNotFoundException("Employee not exist with given Id : " + employeeDto.getId()));
	employee.setFirstName(employeeDto.getFirstName());
	employee.setLastName(employeeDto.getLastName());
	employee.setEmail(employeeDto.getFirstName());
		return modelMapper.map(employeeRepo.save(employee), EmployeeDto.class);
	}

}
