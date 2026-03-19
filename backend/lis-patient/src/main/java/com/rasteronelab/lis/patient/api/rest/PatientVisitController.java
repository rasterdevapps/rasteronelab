package com.rasteronelab.lis.patient.api.rest;

import com.rasteronelab.lis.core.api.ApiResponse;
import com.rasteronelab.lis.core.api.PagedResponse;
import com.rasteronelab.lis.patient.api.dto.PatientVisitRequest;
import com.rasteronelab.lis.patient.api.dto.PatientVisitResponse;
import com.rasteronelab.lis.patient.application.service.PatientVisitService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * REST controller for PatientVisit CRUD operations.
 * Nested under patients: /api/v1/patients/{patientId}/visits
 * Restricted to SUPER_ADMIN, ORG_ADMIN, ADMIN, RECEPTIONIST, and LAB_TECHNICIAN roles.
 */
@RestController
@RequestMapping("/api/v1/patients/{patientId}/visits")
@PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ORG_ADMIN', 'ADMIN', 'RECEPTIONIST', 'LAB_TECHNICIAN')")
public class PatientVisitController {

    private final PatientVisitService patientVisitService;

    @PostMapping
    public ResponseEntity<ApiResponse<PatientVisitResponse>> create(
            @PathVariable UUID patientId,
            @Valid @RequestBody PatientVisitRequest request) {
        PatientVisitResponse response = patientVisitService.create(patientId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Patient visit created successfully", response));
    }

    @GetMapping("/{visitId}")
    public ResponseEntity<ApiResponse<PatientVisitResponse>> getById(
            @PathVariable UUID patientId,
            @PathVariable UUID visitId) {
        PatientVisitResponse response = patientVisitService.getById(patientId, visitId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PagedResponse<PatientVisitResponse>>> getByPatientId(
            @PathVariable UUID patientId, Pageable pageable) {
        Page<PatientVisitResponse> page = patientVisitService.getByPatientId(patientId, pageable);
        return ResponseEntity.ok(ApiResponse.success(PagedResponse.of(page)));
    }

    @PutMapping("/{visitId}")
    public ResponseEntity<ApiResponse<PatientVisitResponse>> update(
            @PathVariable UUID patientId,
            @PathVariable UUID visitId,
            @Valid @RequestBody PatientVisitRequest request) {
        PatientVisitResponse response = patientVisitService.update(patientId, visitId, request);
        return ResponseEntity.ok(ApiResponse.success("Patient visit updated successfully", response));
    }

    @DeleteMapping("/{visitId}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable UUID patientId,
            @PathVariable UUID visitId) {
        patientVisitService.delete(patientId, visitId);
        return ResponseEntity.ok(ApiResponse.successMessage("Patient visit deleted successfully"));
    }

    public PatientVisitController(PatientVisitService patientVisitService) {
        this.patientVisitService = patientVisitService;
    }

}
