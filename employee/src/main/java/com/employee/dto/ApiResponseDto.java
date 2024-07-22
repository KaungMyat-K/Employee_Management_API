package com.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
    description = "EmployeeDto Model Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
    
    @Schema(
    description = "EmployeeDto Model Information"
    )
    private EmployeeDto employeeDto;

    @Schema(
    description = "DepartmentDto Model Information"
    )
    private DepartmentDto departmentDto;

    @Schema(
    description = "OrganizationDto Model Information"
    )
    private OrganizationDto organizationDto;
}
