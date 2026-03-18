package com.rasteronelab.lis.admin.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response DTO for NumberSeries entity.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumberSeriesResponse {

    private UUID id;
    private UUID branchId;
    private String entityType;
    private String prefix;
    private String suffix;
    private Long currentNumber;
    private Integer paddingLength;
    private String formatPattern;
    private String resetFrequency;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
