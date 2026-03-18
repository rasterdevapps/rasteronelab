package com.rasteronelab.lis.admin.domain.repository;

import com.rasteronelab.lis.admin.domain.model.WorkingHours;
import com.rasteronelab.lis.core.domain.repository.BranchAwareRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for WorkingHours entity.
 * Extends BranchAwareRepository for branch-scoped queries with soft-delete filtering.
 */
@Repository
public interface WorkingHoursRepository extends BranchAwareRepository<WorkingHours> {

    Optional<WorkingHours> findByBranchIdAndDayOfWeekAndIsDeletedFalse(UUID branchId, Integer dayOfWeek);

    boolean existsByBranchIdAndDayOfWeekAndIsDeletedFalse(UUID branchId, Integer dayOfWeek);
}
