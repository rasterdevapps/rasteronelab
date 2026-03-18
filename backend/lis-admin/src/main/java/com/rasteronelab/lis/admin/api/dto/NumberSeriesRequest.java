package com.rasteronelab.lis.admin.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for creating or updating a Number Series.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumberSeriesRequest {

    @NotBlank(message = "Entity type is required")
    @Size(max = 30, message = "Entity type must not exceed 30 characters")
    private String entityType;

    @NotBlank(message = "Prefix is required")
    @Size(max = 20, message = "Prefix must not exceed 20 characters")
    private String prefix;

    @Size(max = 20, message = "Suffix must not exceed 20 characters")
    private String suffix;

    @NotNull(message = "Current number is required")
    private Long currentNumber;

    private Integer paddingLength;

    @Size(max = 100, message = "Format pattern must not exceed 100 characters")
    private String formatPattern;

    @Size(max = 20, message = "Reset frequency must not exceed 20 characters")
    private String resetFrequency;

    private Boolean isActive;
}
