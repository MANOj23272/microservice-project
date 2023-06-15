package net.javaguides.departmentservice.controller;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
	
	private DepartmentService departmentService;
	@Operation(
			summary = " save Department ",
			description = "save Department ")
	
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody  DepartmentDto departmentDto){
		DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(saveDepartment,HttpStatus.CREATED);
	}
	
//	@GetMapping("{id}")
//	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") Long departmentId){
//		DepartmentDto department = departmentService.getDepartment(departmentId);
//		return new ResponseEntity<>(department,HttpStatus.OK);
//	}
	
	@Operation(
			summary = " get Department ",
			description = "get Department ")
	
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 CREATED"
			)
	
	
	@GetMapping("{department-Code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-Code") String departmentCode){
		DepartmentDto department = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(department,HttpStatus.OK);
	
		}
}
