package com.silviq.silvahr.form.core.mapper;

import com.silviq.silvahr.form.core.dto.FormApprovalLogRequest;
import com.silviq.silvahr.form.core.dto.FormApprovalLogResponse;
import com.silviq.silvahr.form.core.entity.FormApprovalLogEntity;

public interface FormApprovalLogMapper {
    FormApprovalLogEntity requestToEntity(FormApprovalLogRequest formApprovalLogRequest) throws Exception;
    FormApprovalLogRequest entityToRequest(FormApprovalLogEntity formApprovalLogEntity);
    FormApprovalLogEntity responseToEntity(FormApprovalLogResponse formApprovalLogResponse);
    FormApprovalLogResponse entityToResponse(FormApprovalLogEntity formApprovalLogEntity);
}
