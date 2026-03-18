package com.rasteronelab.lis.admin.api.mapper;

import com.rasteronelab.lis.admin.api.dto.NumberSeriesRequest;
import com.rasteronelab.lis.admin.api.dto.NumberSeriesResponse;
import com.rasteronelab.lis.admin.domain.model.NumberSeries;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * MapStruct mapper for NumberSeries entity ↔ DTO conversion.
 */
@Mapper(componentModel = "spring")
public interface NumberSeriesMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    NumberSeries toEntity(NumberSeriesRequest request);

    NumberSeriesResponse toResponse(NumberSeries numberSeries);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    void updateEntity(NumberSeriesRequest request, @MappingTarget NumberSeries numberSeries);
}
