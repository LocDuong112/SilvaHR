package com.silviq.silvahr.form.overtime.mapper;

import com.silviq.silvahr.form.overtime.dto.OvertimeFormResponse;
import com.silviq.silvahr.form.overtime.dto.OvertimeTypeRequest;
import com.silviq.silvahr.form.overtime.dto.OvertimeTypeResponse;
import com.silviq.silvahr.form.overtime.entity.OvertimeFormEntity;
import com.silviq.silvahr.form.overtime.entity.OvertimeTypeEntity;

public interface OvertimeTypeMapper {
    OvertimeTypeEntity requestToEntity(OvertimeTypeRequest overtimeTypeRequest) throws Exception;
    OvertimeTypeRequest entityToRequest(OvertimeTypeEntity overtimeTypeEntity);
    OvertimeTypeEntity responseToEntity(OvertimeTypeResponse overtimeTypeResponse);
    OvertimeTypeResponse entityToResponse(OvertimeTypeEntity overtimeTypeEntity);
}
