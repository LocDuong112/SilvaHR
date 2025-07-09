package com.silviq.silvahr.form.leave.mapper;

import com.silviq.silvahr.form.leave.dto.LeaveFormRequest;
import com.silviq.silvahr.form.leave.dto.LeaveFormResponse;
import com.silviq.silvahr.form.leave.entity.LeaveFormEntity;

public interface LeaveFormMapper {
    LeaveFormEntity requestToEntity(LeaveFormRequest leaveFormRequest) throws Exception;
    LeaveFormRequest entityToRequest(LeaveFormEntity leaveFormEntity);
    LeaveFormEntity responseToEntity(LeaveFormResponse leaveFormResponse);
    LeaveFormResponse entityToResponse(LeaveFormEntity leaveFormEntity);
}
