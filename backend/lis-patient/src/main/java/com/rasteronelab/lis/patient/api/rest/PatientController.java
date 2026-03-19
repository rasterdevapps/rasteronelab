package com.rasteronelab.lis.patient.api.rest;

import com.rasteronelab.lis.core.api.ApiResponse;
import com.rasteronelab.lis.core.api.PagedResponse;
import com.rasteronelab.lis.patient.api.dto.PatientRequest;
import com.rasteronelab.lis.patient.api.dto.PatientResponse;
import com.rasteronelab.lis.patient.application.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for Patient CRUD operations.
 * Restricted to SUPER_ADMIN, ORG_ADMIN, ADMIN, RECEPTIONIST, and LAB_TECHNICIAN roles.
 */
@RestController
@RequestMapping("/api/v1/patients")
@PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ORG_ADMIN', 'ADMIN', 'RECEPTIONIST', 'LAB_TECHNICIAN')")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<ApiResponse<PatientResponse>> create(
            @Valid @RequestBody PatientRequest request) {
        PatientResponse response = patientService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Patient created successfully", response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PatientResponse>> getById(@PathVariable UUID id) {
        PatientResponse response = patientService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PagedResponse<PatientResponse>>> getAll(Pageable pageable) {
        Page<PatientResponse> page = patientService.getAll(pageable);
        return ResponseEntity.ok(ApiResponse.success(PagedResponse.of(page)));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<PagedResponse<PatientResponse>>> search(
            @RequestParam("q") String searchTerm, Pageable pageable) {
        Page<PatientResponse> page = patientService.search(searchTerm, pageable);
        return ResponseEntity.ok(ApiResponse.success(PagedResponse.of(page)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PatientResponse>> update(
            @PathVariable UUID id,
            @Valid @RequestBody PatientRequest request) {
        PatientResponse response = patientService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success("Patient updated successfully", response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        patientService.delete(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Patient deleted successfully"));
    }

    @GetMapping("/duplicates")
    public ResponseEntity<ApiResponse<List<PatientResponse>>> findDuplicates(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String phone,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob) {
        List<PatientResponse> duplicates = patientService.findDuplicates(firstName, lastName, phone, dob);
        return ResponseEntity.ok(ApiResponse.success(duplicates));
    }

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

}
