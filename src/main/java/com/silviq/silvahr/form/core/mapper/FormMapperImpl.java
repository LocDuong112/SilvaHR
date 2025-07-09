package com.silviq.silvahr.form.core.mapper;

import com.silviq.silvahr.form.core.dto.FormRequest;
import com.silviq.silvahr.form.core.dto.FormResponse;
import com.silviq.silvahr.form.core.entity.FormEntity;
import com.silviq.silvahr.form.leave.mapper.LeaveFormMapper;
import com.silviq.silvahr.form.overtime.mapper.OvertimeFormMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FormMapperImpl implements FormMapper {
    @Autowired
    private LeaveFormMapper leaveFormMapper;

    @Autowired
    private OvertimeFormMapper overtimeFormMapper;

    @Override
    public FormEntity requestToEntity(FormRequest formRequest) throws Exception {
        return null;
    }

    @Override
    public FormRequest entityToRequest(FormEntity formEntity) {
        return null;
    }

    @Override
    public FormEntity responseToEntity(FormResponse formResponse) {
        return null;
    }

    @Override
    public FormResponse entityToResponse(FormEntity formEntity) {

        return FormResponse.builder()
                .id(formEntity.getId())
                .formName(formEntity.getFormName())
                .formDescription(formEntity.getFormDescription())
                .formStatus(formEntity.getFormStatusEntity().getStatus())
                .leaveFormResponse(leaveFormMapper.entityToResponse(formEntity.getLeaveFormEntity()))
                .overtimeFormResponse(overtimeFormMapper.entityToResponse(formEntity.getOvertimeFormEntity()))
                .build();
    }
}
