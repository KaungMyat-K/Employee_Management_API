package com.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.employee.dto.ApiResponseDto;
import com.employee.dto.DepartmentDto;
import com.employee.dto.EmployeeDto;
import com.employee.dto.OrganizationDto;
import com.employee.entity.Employee;

@Mapper
public interface EmployeeMapper {
    
    EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );

    EmployeeDto mapToEmployeeDto(Employee employee);
    Employee mapToEmployee(EmployeeDto employeeDto);
    ApiResponseDto maptoApiResponseDto(EmployeeDto employeeDto,DepartmentDto departmentDto,OrganizationDto organizationDto);
}
