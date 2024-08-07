package com.department.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
    description = "DepartmentDto Model Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
