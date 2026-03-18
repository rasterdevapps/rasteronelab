package com.rasteronelab.lis.admin.api.mapper;

import com.rasteronelab.lis.admin.api.dto.AppUserRequest;
import com.rasteronelab.lis.admin.api.dto.AppUserResponse;
import com.rasteronelab.lis.admin.domain.model.AppUser;
import org.mapstruct.*;

/**
 * MapStruct mapper for AppUser entity ↔ DTO conversion.
 */
@Mapper(componentModel = "spring")
public interface AppUserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    AppUser toEntity(AppUserRequest request);

    AppUserResponse toResponse(AppUser appUser);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    void updateEntity(AppUserRequest request, @MappingTarget AppUser appUser);
}
