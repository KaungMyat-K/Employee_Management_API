package com.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.dto.DepartmentDto;
import com.department.services.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
   name = "Department Service - Department Controller",
   description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

   @Operation(
      summary = "Save Department REST API",
      description = "Save Department Rest API is used to save department object in a database"
   )
   @ApiResponse(
      responseCode = "201",
      description = "HTTP Status 201 CREATED"
   )
   @PostMapping
   public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
       DepartmentDto saveddepartmentDto =  departmentService.saveDepartment(departmentDto);
       return new ResponseEntity<>(saveddepartmentDto,HttpStatus.CREATED);

    }

   @Operation(
      summary = "Get Department REST API",
      description = "Get Department Rest API is used to Get department object from a database"
   )
   @ApiResponse(
      responseCode = "200",
      description = "HTTP Status 200 SUCCESS"
   )
   @GetMapping("{department-code}")
   public ResponseEntity<DepartmentDto> getDepartmentByDepartmentCode(@PathVariable("department-code") String departmentCode){
       DepartmentDto departmentDto =  departmentService.getDepartmentByCode(departmentCode);
       return new ResponseEntity<>(departmentDto,HttpStatus.OK);

    }

}
