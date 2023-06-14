package net.manoj.organizationservice.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

	private Long id;
	private String organizationName;
	
	private String organizationDescription;
	private String organizationCode;
	private LocalDateTime createdDate;
}
