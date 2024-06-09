package com.employee.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repo.EmployeeRepo;
import com.employee.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.INSTANCE.mapToEmployee(employeeDto);

        Employee savedEmployee =  employeeRepo.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee", "id", employeeId));

        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapToEmployeeDto(employee);

        return employeeDto;
    }




    
}
