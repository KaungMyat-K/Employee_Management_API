package com.organization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.dto.OrganizationDto;
import com.organization.entity.Organization;
import com.organization.mapper.OrganizationMapper;
import com.organization.repo.OrganizationRepo;
import com.organization.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepo organizationRepo;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        
        Organization organization = OrganizationMapper.INSTANCE.mapToOrganization(organizationDto);
        Organization savedOrganization =  organizationRepo.save(organization);
        
       return OrganizationMapper.INSTANCE.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {

        Organization organization = organizationRepo.findByOrganizationCode(organizationCode);

        return OrganizationMapper.INSTANCE.mapToOrganizationDto(organization);
    }
    




}
