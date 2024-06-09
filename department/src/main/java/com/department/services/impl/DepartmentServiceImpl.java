package com.department.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.dto.DepartmentDto;
import com.department.entity.Department;
import com.department.repo.DepartmentRepo;
import com.department.services.DepartmentServices;

@Service
public class DepartmentServiceImpl implements DepartmentServices {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        
       Department department = new Department(departmentDto.getId(),departmentDto.getDepartmentName(),departmentDto.getDepartmentDescription(),departmentDto.getDepartmentCode()); 

       departmentRepo.save(department);

       DepartmentDto saveDepartmentDto = new DepartmentDto(department.getId(),department.getDepartmentName(),department.getDepartmentDescription(),department.getDepartmentCode());

       return saveDepartmentDto;
    }
    
}
