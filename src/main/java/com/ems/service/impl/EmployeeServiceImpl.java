package com.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
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

}
