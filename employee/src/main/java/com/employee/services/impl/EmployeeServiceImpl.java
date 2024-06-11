package com.employee.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.dto.ApiResponseDto;
import com.employee.dto.DepartmentDto;
import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repo.EmployeeRepo;
import com.employee.services.ApiClient;
import com.employee.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ApiClient apiClient;
    //private WebClient webClient;
    // private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.INSTANCE.mapToEmployee(employeeDto);

        Employee savedEmployee =  employeeRepo.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee", "id", employeeId));

        //restTemplate sync
        // ResponseEntity<DepartmentDto>  responseEntity= restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),DepartmentDto.class);
        // DepartmentDto departmentDto = responseEntity.getBody();
    
        //WebClient sync
        //  DepartmentDto departmentDto =  webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();

        DepartmentDto departmentDto = apiClient.getDepartmentByDepartmentCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(employee);

        ApiResponseDto apiResponseDto = EmployeeMapper.INSTANCE.maptoApiResponseDto(employeeDto, departmentDto);

        return apiResponseDto;
    }




    
}
