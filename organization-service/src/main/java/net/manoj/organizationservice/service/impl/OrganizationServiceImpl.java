package net.manoj.organizationservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.manoj.organizationservice.dto.OrganizationDto;
import net.manoj.organizationservice.entity.Organization;
import net.manoj.organizationservice.mapper.OrganizationMapper;
import net.manoj.organizationservice.repository.OrganizationRepository;
import net.manoj.organizationservice.service.OrganizationService;
@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{




	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
		Organization savedOrganization = organizationRepository.save(organization);
		return OrganizationMapper.mapToOrganizationDto(savedOrganization);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {
		Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
		
		
		return OrganizationMapper.mapToOrganizationDto(organization);
	}

}
