package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.ApiResponseDto;
import com.employee.dto.EmployeeDto;
import com.employee.services.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(
   name = "Employee Service - Employee Controller",
   description = "Employee Controller Exposes REST APIs for Employee-Service"
)
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @Operation(
        summary = "Save Employee REST API",
        description = "Save Employee Rest API is used to save employee object in a database"
     )
     @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
     )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
       
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto,HttpStatus.CREATED);
    }
    

    @Operation(
        summary = "Get Employee REST API",
        description = "Get Employee Rest API is used to Get employee object from a database"
     )
     @ApiResponse(
        responseCode = "200",
        description = "HTTP Status 200 SUCCESS"
     )
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
    

}
