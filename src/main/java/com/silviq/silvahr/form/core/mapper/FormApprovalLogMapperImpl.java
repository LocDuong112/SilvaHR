package com.silviq.silvahr.form.core.mapper;

import com.silviq.silvahr.form.core.dto.FormApprovalLogRequest;
import com.silviq.silvahr.form.core.dto.FormApprovalLogResponse;
import com.silviq.silvahr.form.core.entity.FormApprovalLogEntity;
import com.silviq.silvahr.user.staff.mapper.StaffMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FormApprovalLogMapperImpl implements FormApprovalLogMapper {
    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private FormMapper formMapper;

    @Override
    public FormApprovalLogEntity requestToEntity(FormApprovalLogRequest formApprovalLogRequest) throws Exception {
        return null;
    }

    @Override
    public FormApprovalLogRequest entityToRequest(FormApprovalLogEntity formApprovalLogEntity) {
        return null;
    }

    @Override
    public FormApprovalLogEntity responseToEntity(FormApprovalLogResponse formApprovalLogResponse) {
        return null;
    }

    @Override
    public FormApprovalLogResponse entityToResponse(FormApprovalLogEntity formApprovalLogEntity) {
        return FormApprovalLogResponse.builder()
                .id(formApprovalLogEntity.getId())
                .staffResponse(staffMapper.entityToResponse(formApprovalLogEntity.getStaff()))
                .formResponse(formMapper.entityToResponse(formApprovalLogEntity.getForm()))
                .description(formApprovalLogEntity.getDescription())
                .approvalStatus(formApprovalLogEntity.getApprovalStatusEntity().getStatus())
                .step(formApprovalLogEntity.getStep())
                .build();
    }
}
