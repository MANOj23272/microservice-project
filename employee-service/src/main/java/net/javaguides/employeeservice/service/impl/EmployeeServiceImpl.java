package net.javaguides.employeeservice.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ApiFeign apiFeign;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee= new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(),
				employeeDto.getEmail(),employeeDto.getDepartmentCode());
		
		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeDto savedEmployeeDto =  new EmployeeDto(savedEmployee.getId(),savedEmployee.getFirstName(),savedEmployee.getLastName(),
				savedEmployee.getEmail(),savedEmployee.getDepartmentCode());
				
		return savedEmployeeDto;
	}
	@Override
	public ApiResponseDto getEmployeeById(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).get();
		
		DepartmentDto departmentDto = apiFeign.getDepartmentByCode(employee.getDepartmentCode());
		EmployeeDto employeeDto = new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode());
		
		ApiResponseDto apiResponse = new ApiResponseDto();
		apiResponse.setDepartmentDto(departmentDto);
		apiResponse.setEmployeeDto(employeeDto);
		return apiResponse;
	}
	
	

}
