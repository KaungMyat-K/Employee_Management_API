package com.organization.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
    description = "OrganizationDto Model Information"
)
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
