package com.employee.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.dto.DepartmentDto;

@FeignClient(name="DEPARTMENT")
public interface ApiClient {

    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartmentByDepartmentCode(@PathVariable("department-code") String departmentCode);
}
