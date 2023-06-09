package net.javaguides.employeeservice.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.employeeservice.dto.DepartmentDto;


@FeignClient(url= "http://localhost:8080" , value ="DEPARTMENT-SERVICE")
public interface ApiFeign {

	@GetMapping("api/departments/{department-Code}")
	DepartmentDto getDepartmentByCode(@PathVariable("department-Code") String departmentCode);
	
	
}
