package com.rasteronelab.lis.admin.domain.repository;

import com.rasteronelab.lis.admin.domain.model.TATConfiguration;
import com.rasteronelab.lis.core.domain.repository.BranchAwareRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for TATConfiguration entity.
 * Extends BranchAwareRepository for branch-scoped queries with soft-delete filtering.
 */
@Repository
public interface TATConfigurationRepository extends BranchAwareRepository<TATConfiguration> {

    Page<TATConfiguration> findAllByBranchIdAndTestIdAndIsDeletedFalse(UUID branchId, UUID testId, Pageable pageable);

    Page<TATConfiguration> findAllByBranchIdAndDepartmentIdAndIsDeletedFalse(UUID branchId, UUID departmentId, Pageable pageable);
}
