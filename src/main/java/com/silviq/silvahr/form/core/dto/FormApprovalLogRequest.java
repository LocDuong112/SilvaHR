package com.silviq.silvahr.form.core.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormApprovalLogRequest {
    private Long staffId;
    private String description;
}
