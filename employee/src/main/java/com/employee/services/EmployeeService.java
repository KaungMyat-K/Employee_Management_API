package com.employee.services;

import com.employee.dto.EmployeeDto;

public interface EmployeeService {
    
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
