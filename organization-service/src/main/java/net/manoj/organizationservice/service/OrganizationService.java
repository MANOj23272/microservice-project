package net.manoj.organizationservice.service;

import net.manoj.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto saveOrganization(OrganizationDto organizationDto);
	OrganizationDto getOrganizationByCode(String organizationCode);
}
