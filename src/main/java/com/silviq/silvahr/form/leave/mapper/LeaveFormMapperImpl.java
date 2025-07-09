package com.silviq.silvahr.form.leave.mapper;

import com.silviq.silvahr.form.leave.dto.LeaveFormRequest;
import com.silviq.silvahr.form.leave.dto.LeaveFormResponse;
import com.silviq.silvahr.form.leave.entity.LeaveFormEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LeaveFormMapperImpl implements LeaveFormMapper {
    @Override
    public LeaveFormEntity requestToEntity(LeaveFormRequest leaveFormRequest) throws Exception {
        return null;
    }

    @Override
    public LeaveFormRequest entityToRequest(LeaveFormEntity leaveFormEntity) {
        return null;
    }

    @Override
    public LeaveFormEntity responseToEntity(LeaveFormResponse leaveFormResponse) {
        return null;
    }

    @Override
    public LeaveFormResponse entityToResponse(LeaveFormEntity leaveFormEntity) {
        return LeaveFormResponse.builder()
                .id(leaveFormEntity.getId())
                .leaveReason(leaveFormEntity.getLeaveReason())
                .startDateTime(leaveFormEntity.getStartDateTime())
                .endDateTime(leaveFormEntity.getEndDateTime())
                .leaveFormType(leaveFormEntity.getLeaveFormTypeEntity().getType())
                .build();
    }
}
