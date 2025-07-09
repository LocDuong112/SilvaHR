package com.silviq.silvahr.form.leave.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveFormResponse {
    private Long id;

    private String leaveReason;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private String leaveFormType;
}
