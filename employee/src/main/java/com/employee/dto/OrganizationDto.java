package com.employee.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    

    private Long id;
    private String organizationtName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDateTime createdDate;
}
