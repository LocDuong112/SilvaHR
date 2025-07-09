package com.silviq.silvahr.form.overtime.mapper;

import com.silviq.silvahr.form.overtime.dto.OvertimeFormResponse;
import com.silviq.silvahr.form.overtime.dto.OvertimeTypeRequest;
import com.silviq.silvahr.form.overtime.dto.OvertimeTypeResponse;
import com.silviq.silvahr.form.overtime.entity.OvertimeTypeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OvertimeTypeMapperImpl implements OvertimeTypeMapper {

    @Override
    public OvertimeTypeEntity requestToEntity(OvertimeTypeRequest overtimeTypeRequest) throws Exception {
        return null;
    }

    @Override
    public OvertimeTypeRequest entityToRequest(OvertimeTypeEntity overtimeTypeEntity) {
        return null;
    }

    @Override
    public OvertimeTypeEntity responseToEntity(OvertimeTypeResponse overtimeTypeResponse) {
        return null;
    }

    @Override
    public OvertimeTypeResponse entityToResponse(OvertimeTypeEntity overtimeTypeEntity) {
        return OvertimeTypeResponse.builder()
                .id(overtimeTypeEntity.getId())
                .OTType(overtimeTypeEntity.getOTType())
                .payMultiplier(overtimeTypeEntity.getPayMultiplier())
                .startTime(overtimeTypeEntity.getStartTime())
                .endTime(overtimeTypeEntity.getEndTime())
                .build();
    }
}
