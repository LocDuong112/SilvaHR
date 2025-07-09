package com.silviq.silvahr.form.overtime.mapper;

import com.silviq.silvahr.form.overtime.dto.OvertimeFormRequest;
import com.silviq.silvahr.form.overtime.dto.OvertimeFormResponse;
import com.silviq.silvahr.form.overtime.dto.OvertimeTypeRequest;
import com.silviq.silvahr.form.overtime.entity.OvertimeFormEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OvertimeFormMapperImpl implements OvertimeFormMapper {
    @Autowired
    private OvertimeTypeMapper overtimeTypeMapper;

    @Override
    public OvertimeFormEntity requestToEntity(OvertimeFormRequest overtimeFormRequest) throws Exception {
        return null;
    }

    @Override
    public OvertimeFormRequest entityToRequest(OvertimeFormEntity overtimeFormEntity) {
        return null;
    }

    @Override
    public OvertimeFormEntity responseToEntity(OvertimeFormResponse overtimeFormResponse) {
        return null;
    }

    @Override
    public OvertimeFormResponse entityToResponse(OvertimeFormEntity overtimeFormEntity) {
        return OvertimeFormResponse.builder()
                .id(overtimeFormEntity.getId())
                .reason(overtimeFormEntity.getReason())
                .overtimeTypeResponse(overtimeTypeMapper.entityToResponse(overtimeFormEntity.getOvertimeTypeEntity()))
                .build();
    }
}
