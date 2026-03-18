package com.rasteronelab.lis.admin.domain.model;

import com.rasteronelab.lis.core.domain.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Doctor entity (L3 branch-level).
 * Extends BaseEntity for multi-branch support via branchId.
 * Represents a referring doctor within a branch.
 */
@Entity
@Table(name = "doctor")
@Getter
@Setter
public class Doctor extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "referral_commission_percent")
    private BigDecimal referralCommissionPercent;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
