package com.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.dto.OrganizationDto;
import com.organization.service.OrganizationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService ;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto,HttpStatus.CREATED);
    }

    @GetMapping("{organization-code}")
    public ResponseEntity<OrganizationDto> getMethodName(@PathVariable("organization-code") String organizationCode) {
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organizationDto,HttpStatus.OK);
    }
    
    
}
