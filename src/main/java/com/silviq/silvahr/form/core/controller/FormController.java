package com.silviq.silvahr.form.core.controller;

import com.silviq.silvahr.form.core.dto.FormRequest;
import com.silviq.silvahr.form.core.dto.FormResponse;
import com.silviq.silvahr.form.core.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/form")
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/leave")
    public FormResponse createLeave(@RequestBody FormRequest formRequest) throws Exception {
        return formService.createLeaveForm(formRequest);
    }
}
