package com.department.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.department.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    
    Optional<Department> findByDepartmentCode(String departmentCode);
}
