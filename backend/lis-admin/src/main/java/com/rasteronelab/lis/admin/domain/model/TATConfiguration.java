package com.rasteronelab.lis.admin.domain.model;

import com.rasteronelab.lis.core.domain.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * TAT (Turnaround Time) Configuration entity (L3 branch-level).
 * Defines expected turnaround times for tests/departments by urgency level.
 */
@Entity
@Table(name = "tat_configuration")
@Getter
@Setter
public class TATConfiguration extends BaseEntity {

    @Column(name = "test_id", insertable = false, updatable = false)
    private UUID testId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestMaster test;

    @Column(name = "department_id", insertable = false, updatable = false)
    private UUID departmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "routine_hours", nullable = false)
    private Integer routineHours;

    @Column(name = "stat_hours")
    private Integer statHours;

    @Column(name = "critical_hours")
    private Integer criticalHours;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
