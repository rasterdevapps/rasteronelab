package com.rasteronelab.lis.admin.api.mapper;

import com.rasteronelab.lis.admin.api.dto.WorkingHoursRequest;
import com.rasteronelab.lis.admin.api.dto.WorkingHoursResponse;
import com.rasteronelab.lis.admin.domain.model.WorkingHours;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * MapStruct mapper for WorkingHours entity ↔ DTO conversion.
 */
@Mapper(componentModel = "spring")
public interface WorkingHoursMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    WorkingHours toEntity(WorkingHoursRequest request);

    WorkingHoursResponse toResponse(WorkingHours workingHours);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    void updateEntity(WorkingHoursRequest request, @MappingTarget WorkingHours workingHours);
}
