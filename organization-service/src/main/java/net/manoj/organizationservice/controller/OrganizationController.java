package net.manoj.organizationservice.controller;

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
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.manoj.organizationservice.dto.OrganizationDto;
import net.manoj.organizationservice.service.OrganizationService;


@Tag(
		name = " Rest Api Documentation",
		description = " Rest Api Description"
		)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;
	@Operation(
			summary = " save organization ",
			description = "save organization ")
	
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
		OrganizationDto saveOrganization = organizationService.saveOrganization(organizationDto);
		
		return new ResponseEntity<>(saveOrganization,HttpStatus.CREATED);
	}
	
	@Operation(
			summary = " get organization ",
			description = "get organization ")
	
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 CREATED"
			)
	
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String  organizationCode){
		OrganizationDto organizationByCode = organizationService.getOrganizationByCode(organizationCode);
		
		return ResponseEntity.ok(organizationByCode);
	}
}
