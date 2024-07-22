package com.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.dto.OrganizationDto;
import com.organization.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(
   name = "Organization Service - Organization Controller",
   description = "Organization Controller Exposes REST APIs for Organization-Service"
)
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService ;

    @Operation(
        summary = "Save Organization REST API",
        description = "Save Organization Rest API is used to save organization object in a database"
     )
     @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
     )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto,HttpStatus.CREATED);
    }

   @Operation(
      summary = "Get Organization REST API",
      description = "Get Organization Rest API is used to Get organization object from a database"
   )
   @ApiResponse(
      responseCode = "200",
      description = "HTTP Status 200 SUCCESS"
   )
    @GetMapping("{organization-code}")
    public ResponseEntity<OrganizationDto> getMethodName(@PathVariable("organization-code") String organizationCode) {
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organizationDto,HttpStatus.OK);
    }
    
    
}
