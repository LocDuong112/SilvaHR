package com.silviq.silvahr.form.overtime.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OvertimeFormResponse {
    private Long id;

    private String reason;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private OvertimeTypeResponse overtimeTypeResponse;
}
