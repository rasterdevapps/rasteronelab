package com.rasteronelab.lis.admin.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response DTO for PriceCatalog entity.
 * Includes resolved testName and panelName for display.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceCatalogResponse {

    private UUID id;
    private UUID branchId;
    private UUID testId;
    private String testName;
    private UUID panelId;
    private String panelName;
    private String rateListType;
    private BigDecimal price;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
