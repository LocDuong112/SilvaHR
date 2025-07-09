package com.silviq.silvahr.form.core.mapper;

import com.silviq.silvahr.form.core.dto.FormRequest;
import com.silviq.silvahr.form.core.dto.FormResponse;
import com.silviq.silvahr.form.core.entity.FormEntity;

public interface FormMapper {
    FormEntity requestToEntity(FormRequest formRequest) throws Exception;
    FormRequest entityToRequest(FormEntity formEntity);
    FormEntity responseToEntity(FormResponse formResponse);
    FormResponse entityToResponse(FormEntity formEntity);
}
