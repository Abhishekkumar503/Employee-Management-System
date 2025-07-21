package com.ems.mapper;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToDto (Employee employee)
	{
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getFirstName()
				);
	}

	public Employee mapToEntity(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
	}
}
