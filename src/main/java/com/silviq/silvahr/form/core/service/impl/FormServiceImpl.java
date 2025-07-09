package com.silviq.silvahr.form.core.service.impl;

import com.silviq.silvahr.form.core.dto.FormRequest;
import com.silviq.silvahr.form.core.dto.FormResponse;
import com.silviq.silvahr.form.core.entity.FormEntity;
import com.silviq.silvahr.form.core.mapper.FormMapper;
import com.silviq.silvahr.form.core.repository.FormRepository;
import com.silviq.silvahr.form.core.service.FormService;
import com.silviq.silvahr.user.staff.entity.StaffEntity;
import com.silviq.silvahr.user.staff.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private FormMapper formMapper;

    @Override
    public FormResponse createLeaveForm(FormRequest formRequest) throws Exception {
        // Check for existing staff id
        Optional<StaffEntity> optionalStaff = staffRepository.findById(formRequest.getRequestStaffId());
        if (optionalStaff.isEmpty()) {
            log.info("Staff id={} is not available!", formRequest.getRequestStaffId());
            throw new Exception("Staff id is not available!");
        }

        // Check if staff already request a leave form with same hour
        Optional<FormEntity> optionalForm = formRepository.findSickLeave(formRequest.getRequestStaffId(),
                                                                        formRequest.getLeaveFormRequest().getStartDateTime(),
                                                                        formRequest.getLeaveFormRequest().getEndDateTime());

        if (optionalForm.isPresent()) {
            log.info("Form id = {} is existing as requested!", optionalForm.get().getId());
            return formMapper.entityToResponse(optionalForm.get());
        }

        // Create form with status 01: PENDING
        // Create leave form
        // Create approval log
        return null;
    }
}
