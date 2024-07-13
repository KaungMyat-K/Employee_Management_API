package com.employee.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.dto.ApiResponseDto;
import com.employee.dto.DepartmentDto;
import com.employee.dto.EmployeeDto;
import com.employee.dto.OrganizationDto;
import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repo.EmployeeRepo;
import com.employee.services.ApiClient;
import com.employee.services.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private WebClient webClient;
    // private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.INSTANCE.mapToEmployee(employeeDto);

        Employee savedEmployee =  employeeRepo.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    //@CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {

        LOGGER.info("inside getEmployeeById method");  
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee", "id", employeeId));

        //restTemplate sync
        // ResponseEntity<DepartmentDto>  responseEntity= restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),DepartmentDto.class);
        // DepartmentDto departmentDto = responseEntity.getBody();
    
        //WebClient sync
        DepartmentDto departmentDto =  webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();

        //DepartmentDto departmentDto = apiClient.getDepartmentByDepartmentCode(employee.getDepartmentCode());

        OrganizationDto organizationDto = webClient.get().uri("http://localhost:8080/api/organizations/"+employee.getDepartmentCode()).retrieve().bodyToMono(OrganizationDto.class).block();
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(employee);
        ApiResponseDto apiResponseDto = EmployeeMapper.INSTANCE.maptoApiResponseDto(employeeDto, departmentDto,organizationDto);

        return apiResponseDto;
    }


    public ApiResponseDto getDefaultDepartment(Long employeeId,Exception exception) {
        
        LOGGER.info("inside getDefaultDepartment method");

        Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee", "id", employeeId));
    
        //WebClient sync
        DepartmentDto departmentDto =  new DepartmentDto();
        departmentDto.setDepartmentName("something");
        departmentDto.setDepartmentDescription("something");
        departmentDto.setDepartmentCode("something");

        OrganizationDto organizationDto = webClient.get().uri("http://localhost:8080/api/organizations/"+employee.getDepartmentCode()).retrieve().bodyToMono(OrganizationDto.class).block();
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(employee);

        ApiResponseDto apiResponseDto = EmployeeMapper.INSTANCE.maptoApiResponseDto(employeeDto, departmentDto,organizationDto);

        return apiResponseDto;
    }

    
}
