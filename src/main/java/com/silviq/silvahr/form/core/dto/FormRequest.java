package com.silviq.silvahr.form.core.dto;

import com.silviq.silvahr.form.leave.dto.LeaveFormRequest;
import com.silviq.silvahr.form.overtime.dto.OvertimeFormRequest;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormRequest {
    private String formName;

    private String formDescription;

    private String formStatus;

    private LeaveFormRequest leaveFormRequest;

    private OvertimeFormRequest overtimeFormRequest;

    private Long requestStaffId;

    private List<FormApprovalLogRequest> formApprovalLogRequestList;
}
