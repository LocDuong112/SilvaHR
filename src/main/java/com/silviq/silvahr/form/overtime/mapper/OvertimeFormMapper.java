package com.silviq.silvahr.form.overtime.mapper;

import com.silviq.silvahr.form.overtime.dto.OvertimeFormRequest;
import com.silviq.silvahr.form.overtime.dto.OvertimeFormResponse;
import com.silviq.silvahr.form.overtime.dto.OvertimeTypeRequest;
import com.silviq.silvahr.form.overtime.entity.OvertimeFormEntity;

public interface OvertimeFormMapper {
    OvertimeFormEntity requestToEntity(OvertimeFormRequest overtimeFormRequest) throws Exception;
    OvertimeFormRequest entityToRequest(OvertimeFormEntity overtimeFormEntity);
    OvertimeFormEntity responseToEntity(OvertimeFormResponse overtimeFormResponse);
    OvertimeFormResponse entityToResponse(OvertimeFormEntity overtimeFormEntity);
}
