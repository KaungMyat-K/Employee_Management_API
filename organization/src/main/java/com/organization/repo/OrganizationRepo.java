package com.organization.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.entity.Organization;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization,Long> {
    
    Organization findByOrganizationCode(String organizationCode);

}
