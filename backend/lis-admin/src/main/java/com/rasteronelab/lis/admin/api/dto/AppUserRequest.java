package com.rasteronelab.lis.admin.api.dto;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * Request DTO for creating or updating an application user.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserRequest {

    @NotBlank(message = "Keycloak user ID is required")
    @Size(max = 100, message = "Keycloak user ID must not exceed 100 characters")
    private String keycloakUserId;

    @NotBlank(message = "Username is required")
    @Size(max = 100, message = "Username must not exceed 100 characters")
    private String username;

    @Size(max = 200, message = "Email must not exceed 200 characters")
    @Email(message = "Email must be a valid email address")
    private String email;

    @Size(max = 100, message = "First name must not exceed 100 characters")
    private String firstName;

    @Size(max = 100, message = "Last name must not exceed 100 characters")
    private String lastName;

    @Size(max = 50, message = "Employee ID must not exceed 50 characters")
    private String employeeId;

    @Size(max = 100, message = "Department must not exceed 100 characters")
    private String department;

    @Size(max = 100, message = "Designation must not exceed 100 characters")
    private String designation;

    @Size(max = 20, message = "Phone must not exceed 20 characters")
    private String phone;

    private Boolean isActive;
}
