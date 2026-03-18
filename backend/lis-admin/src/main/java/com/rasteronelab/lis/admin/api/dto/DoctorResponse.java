package com.rasteronelab.lis.admin.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response DTO for Doctor entity.
 * Includes all entity fields plus audit metadata.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponse {

    private UUID id;
    private UUID branchId;
    private String name;
    private String code;
    private String specialization;
    private String qualification;
    private String registrationNumber;
    private String phone;
    private String email;
    private String address;
    private BigDecimal referralCommissionPercent;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
