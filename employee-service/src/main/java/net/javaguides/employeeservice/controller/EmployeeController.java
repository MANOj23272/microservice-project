package net.javaguides.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;
	@Operation(
			summary = " save Employee ",
			description = "save Employee ")
	
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody  EmployeeDto employeeDto){
		EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(saveEmployee,HttpStatus.CREATED);
	}
	
	@Operation(
			summary = " get Employee ",
			description = "get Employee ")
	
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 CREATED"
			)
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id")  Long id){
		ApiResponseDto getEmployee = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(getEmployee,HttpStatus.OK);
	}
}
