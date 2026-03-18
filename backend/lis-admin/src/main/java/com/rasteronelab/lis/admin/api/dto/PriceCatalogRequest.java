package com.rasteronelab.lis.admin.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Request DTO for creating or updating a Price Catalog entry.
 * Either testId or panelId must be provided, but not both.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceCatalogRequest {

    private UUID testId;

    private UUID panelId;

    @NotBlank(message = "Rate list type is required")
    @Size(max = 30, message = "Rate list type must not exceed 30 characters")
    private String rateListType;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    private LocalDate effectiveFrom;

    private LocalDate effectiveTo;

    private Boolean isActive;
}
