package com.silviq.silvahr.form.core.service;

import com.silviq.silvahr.form.core.dto.FormRequest;
import com.silviq.silvahr.form.core.dto.FormResponse;
import jakarta.transaction.Transactional;

@Transactional
public interface FormService {
    FormResponse createLeaveForm(FormRequest formRequest) throws Exception;
}
