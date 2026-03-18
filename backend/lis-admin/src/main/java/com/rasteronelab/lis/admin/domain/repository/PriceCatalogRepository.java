package com.rasteronelab.lis.admin.domain.repository;

import com.rasteronelab.lis.admin.domain.model.PriceCatalog;
import com.rasteronelab.lis.core.domain.repository.BranchAwareRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for PriceCatalog entity.
 * Extends BranchAwareRepository for branch-scoped queries with soft-delete filtering.
 */
@Repository
public interface PriceCatalogRepository extends BranchAwareRepository<PriceCatalog> {

    Page<PriceCatalog> findAllByBranchIdAndTestIdAndIsDeletedFalse(UUID branchId, UUID testId, Pageable pageable);

    Page<PriceCatalog> findAllByBranchIdAndPanelIdAndIsDeletedFalse(UUID branchId, UUID panelId, Pageable pageable);

    Page<PriceCatalog> findAllByBranchIdAndRateListTypeAndIsDeletedFalse(UUID branchId, String rateListType, Pageable pageable);

    Page<PriceCatalog> findAllByBranchIdAndIsActiveAndIsDeletedFalse(UUID branchId, Boolean isActive, Pageable pageable);
}
