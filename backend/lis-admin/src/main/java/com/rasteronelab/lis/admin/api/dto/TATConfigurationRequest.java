package com.rasteronelab.lis.admin.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Request DTO for creating or updating a TAT Configuration.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TATConfigurationRequest {

    private UUID testId;

    private UUID departmentId;

    @NotNull(message = "Routine hours is required")
    private Integer routineHours;

    private Integer statHours;

    private Integer criticalHours;

    private Boolean isActive;
}
