package com.rasteronelab.lis.admin.api.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response DTO for AppUser entity.
 * Includes all entity fields plus audit metadata.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserResponse {

    private UUID id;
    private UUID branchId;
    private String keycloakUserId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String employeeId;
    private String department;
    private String designation;
    private String phone;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
