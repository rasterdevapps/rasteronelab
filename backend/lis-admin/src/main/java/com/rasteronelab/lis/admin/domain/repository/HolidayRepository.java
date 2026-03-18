package com.rasteronelab.lis.admin.domain.repository;

import com.rasteronelab.lis.admin.domain.model.Holiday;
import com.rasteronelab.lis.core.domain.repository.BranchAwareRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for Holiday entity.
 * Extends BranchAwareRepository for branch-scoped queries with soft-delete filtering.
 */
@Repository
public interface HolidayRepository extends BranchAwareRepository<Holiday> {

    Optional<Holiday> findByBranchIdAndHolidayDateAndIsDeletedFalse(UUID branchId, LocalDate holidayDate);

    boolean existsByBranchIdAndHolidayDateAndIsDeletedFalse(UUID branchId, LocalDate holidayDate);
}
