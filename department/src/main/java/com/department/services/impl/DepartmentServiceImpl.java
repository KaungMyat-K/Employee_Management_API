package com.department.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.dto.DepartmentDto;
import com.department.entity.Department;
import com.department.exception.ResourceNotFoundException;
import com.department.mapper.DepartmentMapper;
import com.department.repo.DepartmentRepo;
import com.department.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

       Department department = DepartmentMapper.INSTANCE.mapToDepartment(departmentDto);

       Department savedDepartment = departmentRepo.save(department);

       DepartmentDto saveDepartmentDto = DepartmentMapper.INSTANCE.mapToDepartmentDto(savedDepartment);

       return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        
        Department department = departmentRepo.findByDepartmentCode(code).orElseThrow(()->new ResourceNotFoundException("Department", "id",code));

        DepartmentDto DepartmentDto = DepartmentMapper.INSTANCE.mapToDepartmentDto(department);

        return DepartmentDto;
    }
    
}
