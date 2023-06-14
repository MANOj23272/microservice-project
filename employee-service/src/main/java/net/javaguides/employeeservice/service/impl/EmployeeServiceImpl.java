package net.javaguides.employeeservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ApiFeign apiFeign;
	private WebClient webClient;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//		Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
//				employeeDto.getEmail(), employeeDto.getDepartmentCode());
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		Employee savedEmployee = employeeRepository.save(employee);
//		EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
//				savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode());
		
		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);

		return savedEmployeeDto;
	}

//	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	@Override
	public ApiResponseDto getEmployeeById(Long employeeId) {
		
		LOGGER.info("inside getEmployeeID");
		Employee employee = employeeRepository.findById(employeeId).get();

		DepartmentDto departmentDto = apiFeign.getDepartmentByCode(employee.getDepartmentCode());
		
		OrganizationDto organizationDto = webClient.get().uri("http://localhost:8083/api/organizations/"+ employee.getOrganizationCode()).
				retrieve().bodyToMono(OrganizationDto.class).block();
		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		ApiResponseDto apiResponse = new ApiResponseDto();
		apiResponse.setDepartmentDto(departmentDto);
		apiResponse.setEmployeeDto(employeeDto);
		apiResponse.setOrganizationDto(organizationDto);
		return apiResponse;
	}

	public ApiResponseDto getDefaultDepartment(Long employeeId,Exception exception) {
		LOGGER.info("inside getDefaultDepartment");

		Employee employee = employeeRepository.findById(employeeId).get();

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R&D department ");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("RESEARCH AND DEVELOPMENT DEPARTMENT");
		
		
		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

		ApiResponseDto apiResponse = new ApiResponseDto();
		apiResponse.setDepartmentDto(departmentDto);
		apiResponse.setEmployeeDto(employeeDto);
		return apiResponse;
	}

}
