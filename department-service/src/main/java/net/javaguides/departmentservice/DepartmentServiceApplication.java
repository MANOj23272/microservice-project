package net.javaguides.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		
		info = @Info(
				title = "spring boot Rest Api Documentation",
				description = "Spring boot Rest Api Documentation",
				version = "v1.0",
				contact = @Contact(
							name = "MANOJ",
							email = "panjinimanojkumar@gmail.com",
							url = "https://www.manoj.net"
						),
				license = @License(
						name= "Apache 2.0",
						url = "https://www.manoj.net/license"
						)
				),
		externalDocs = @ExternalDocumentation(
					description = "Spring Boot User Management Documentation",
					url = "https://www.manoj.net/user_management.html"
				)
		
 		)
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
