package com.rasteronelab.lis.admin.api.mapper;

import com.rasteronelab.lis.admin.api.dto.TATConfigurationRequest;
import com.rasteronelab.lis.admin.api.dto.TATConfigurationResponse;
import com.rasteronelab.lis.admin.domain.model.TATConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * MapStruct mapper for TATConfiguration entity ↔ DTO conversion.
 */
@Mapper(componentModel = "spring")
public interface TATConfigurationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "test", ignore = true)
    @Mapping(target = "testId", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "departmentId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    TATConfiguration toEntity(TATConfigurationRequest request);

    @Mapping(source = "test.name", target = "testName")
    @Mapping(source = "department.name", target = "departmentName")
    TATConfigurationResponse toResponse(TATConfiguration tatConfiguration);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "test", ignore = true)
    @Mapping(target = "testId", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "departmentId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    void updateEntity(TATConfigurationRequest request, @MappingTarget TATConfiguration tatConfiguration);
}
