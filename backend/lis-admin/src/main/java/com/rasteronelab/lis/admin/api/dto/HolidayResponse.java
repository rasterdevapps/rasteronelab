package com.rasteronelab.lis.admin.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response DTO for Holiday entity.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HolidayResponse {

    private UUID id;
    private UUID branchId;
    private LocalDate holidayDate;
    private String name;
    private String description;
    private Boolean isHalfDay;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
