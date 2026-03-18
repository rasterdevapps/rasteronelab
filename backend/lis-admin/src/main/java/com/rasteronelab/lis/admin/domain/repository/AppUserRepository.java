package com.rasteronelab.lis.admin.domain.repository;

import com.rasteronelab.lis.admin.domain.model.AppUser;
import com.rasteronelab.lis.core.domain.repository.BranchAwareRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for AppUser entity.
 * Extends BranchAwareRepository for branch-scoped queries with soft-delete filtering.
 */
@Repository
public interface AppUserRepository extends BranchAwareRepository<AppUser> {

    Optional<AppUser> findByKeycloakUserIdAndIsDeletedFalse(String keycloakUserId);

    Optional<AppUser> findByUsernameAndBranchIdAndIsDeletedFalse(String username, UUID branchId);

    boolean existsByUsernameAndBranchIdAndIsDeletedFalse(String username, UUID branchId);

    boolean existsByKeycloakUserIdAndIsDeletedFalse(String keycloakUserId);

    Page<AppUser> findAllByBranchIdAndIsActiveAndIsDeletedFalse(UUID branchId, Boolean isActive, Pageable pageable);

    Page<AppUser> findAllByBranchIdAndIsDeletedFalseAndUsernameContainingIgnoreCase(UUID branchId, String username, Pageable pageable);
}
