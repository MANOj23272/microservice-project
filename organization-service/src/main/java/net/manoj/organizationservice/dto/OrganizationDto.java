package net.manoj.organizationservice.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
		description = "OrganizationDto "
		)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

	private Long id;
	@Schema(
			description = "organization name"
			)
	
	private String organizationName;
	
	private String organizationDescription;
	private String organizationCode;
	private LocalDateTime createdDate;
}
