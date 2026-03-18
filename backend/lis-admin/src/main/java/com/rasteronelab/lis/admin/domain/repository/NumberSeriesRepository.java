package com.rasteronelab.lis.admin.domain.repository;

import com.rasteronelab.lis.admin.domain.model.NumberSeries;
import com.rasteronelab.lis.core.domain.repository.BranchAwareRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for NumberSeries entity.
 * Extends BranchAwareRepository for branch-scoped queries with soft-delete filtering.
 */
@Repository
public interface NumberSeriesRepository extends BranchAwareRepository<NumberSeries> {

    boolean existsByEntityTypeAndBranchIdAndIsDeletedFalse(String entityType, UUID branchId);

    Optional<NumberSeries> findByEntityTypeAndBranchIdAndIsDeletedFalse(String entityType, UUID branchId);
}
