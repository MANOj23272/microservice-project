package net.manoj.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.manoj.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	Organization findByOrganizationCode(String organizationCode);
}
