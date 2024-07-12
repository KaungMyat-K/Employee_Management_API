package com.organization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.organization.dto.OrganizationDto;
import com.organization.entity.Organization;

@Mapper
public interface OrganizationMapper {
    
    OrganizationMapper INSTANCE = Mappers.getMapper( OrganizationMapper.class );

    OrganizationDto mapToOrganizationDto(Organization organization);
    Organization mapToOrganization(OrganizationDto organizationDto);
}
