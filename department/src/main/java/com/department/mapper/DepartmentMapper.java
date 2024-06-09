package com.department.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.department.dto.DepartmentDto;
import com.department.entity.Department;

@Mapper
public interface DepartmentMapper {
    
    DepartmentMapper INSTANCE = Mappers.getMapper( DepartmentMapper.class );

    DepartmentDto mapToDepartmentDto(Department employee);
    Department mapToDepartment(DepartmentDto employeeDto);

}
