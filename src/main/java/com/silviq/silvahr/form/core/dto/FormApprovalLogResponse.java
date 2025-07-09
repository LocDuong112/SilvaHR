package com.silviq.silvahr.form.core.dto;

import com.silviq.silvahr.user.staff.dto.StaffResponse;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormApprovalLogResponse {
    private Long id;
    private StaffResponse staffResponse;
    private FormResponse formResponse;
    private String description;
    private String approvalStatus;
    private int step;
}
