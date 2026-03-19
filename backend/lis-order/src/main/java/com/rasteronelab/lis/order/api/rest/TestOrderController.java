package com.rasteronelab.lis.order.api.rest;

import com.rasteronelab.lis.core.api.ApiResponse;
import com.rasteronelab.lis.core.api.PagedResponse;
import com.rasteronelab.lis.order.api.dto.TestOrderRequest;
import com.rasteronelab.lis.order.api.dto.TestOrderResponse;
import com.rasteronelab.lis.order.application.service.TestOrderService;
import com.rasteronelab.lis.order.domain.model.OrderStatus;
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

import java.util.Map;
import java.util.UUID;

/**
 * REST controller for TestOrder CRUD and state management operations.
 * Restricted to SUPER_ADMIN, ORG_ADMIN, ADMIN, RECEPTIONIST, LAB_TECHNICIAN roles.
 */
@RestController
@RequestMapping("/api/v1/orders")
@PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ORG_ADMIN', 'ADMIN', 'RECEPTIONIST', 'LAB_TECHNICIAN')")
public class TestOrderController {

    private final TestOrderService testOrderService;

    @PostMapping
    public ResponseEntity<ApiResponse<TestOrderResponse>> create(
            @Valid @RequestBody TestOrderRequest request) {
        TestOrderResponse response = testOrderService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Order created successfully", response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TestOrderResponse>> getById(@PathVariable UUID id) {
        TestOrderResponse response = testOrderService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PagedResponse<TestOrderResponse>>> getAll(Pageable pageable) {
        Page<TestOrderResponse> page = testOrderService.getAll(pageable);
        return ResponseEntity.ok(ApiResponse.success(PagedResponse.of(page)));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<ApiResponse<PagedResponse<TestOrderResponse>>> getByPatient(
            @PathVariable UUID patientId, Pageable pageable) {
        Page<TestOrderResponse> page = testOrderService.getByPatient(patientId, pageable);
        return ResponseEntity.ok(ApiResponse.success(PagedResponse.of(page)));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse<PagedResponse<TestOrderResponse>>> getByStatus(
            @PathVariable OrderStatus status, Pageable pageable) {
        Page<TestOrderResponse> page = testOrderService.getByStatus(status, pageable);
        return ResponseEntity.ok(ApiResponse.success(PagedResponse.of(page)));
    }

    @PutMapping("/{id}/place")
    public ResponseEntity<ApiResponse<TestOrderResponse>> placeOrder(@PathVariable UUID id) {
        TestOrderResponse response = testOrderService.placeOrder(id);
        return ResponseEntity.ok(ApiResponse.success("Order placed successfully", response));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<ApiResponse<TestOrderResponse>> cancelOrder(
            @PathVariable UUID id,
            @RequestBody Map<String, String> body) {
        String reason = body.get("reason");
        TestOrderResponse response = testOrderService.cancelOrder(id, reason);
        return ResponseEntity.ok(ApiResponse.success("Order cancelled successfully", response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        testOrderService.delete(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Order deleted successfully"));
    }

    public TestOrderController(TestOrderService testOrderService) {
        this.testOrderService = testOrderService;
    }

}
