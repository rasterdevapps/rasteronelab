package com.rasteronelab.lis.admin.api.mapper;

import com.rasteronelab.lis.admin.api.dto.PriceCatalogRequest;
import com.rasteronelab.lis.admin.api.dto.PriceCatalogResponse;
import com.rasteronelab.lis.admin.domain.model.PriceCatalog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * MapStruct mapper for PriceCatalog entity ↔ DTO conversion.
 */
@Mapper(componentModel = "spring")
public interface PriceCatalogMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "test", ignore = true)
    @Mapping(target = "testId", ignore = true)
    @Mapping(target = "panel", ignore = true)
    @Mapping(target = "panelId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    PriceCatalog toEntity(PriceCatalogRequest request);

    @Mapping(source = "test.name", target = "testName")
    @Mapping(source = "panel.name", target = "panelName")
    PriceCatalogResponse toResponse(PriceCatalog priceCatalog);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "test", ignore = true)
    @Mapping(target = "testId", ignore = true)
    @Mapping(target = "panel", ignore = true)
    @Mapping(target = "panelId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    void updateEntity(PriceCatalogRequest request, @MappingTarget PriceCatalog priceCatalog);
}
