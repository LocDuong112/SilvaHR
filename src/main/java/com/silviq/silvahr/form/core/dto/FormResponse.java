package com.silviq.silvahr.form.core.dto;

import com.silviq.silvahr.form.leave.dto.LeaveFormResponse;
import com.silviq.silvahr.form.overtime.dto.OvertimeFormResponse;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormResponse {
    private Long id;

    private String formName;

    private String formDescription;

    private String formStatus;

    private LeaveFormResponse leaveFormResponse;

    private OvertimeFormResponse overtimeFormResponse;
}
