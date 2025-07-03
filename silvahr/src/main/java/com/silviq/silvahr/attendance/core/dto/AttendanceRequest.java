package com.silviq.silvahr.attendance.core.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AttendanceRequest {
    private Long staffId;

    private LocalDateTime checkinDateTime;

    private LocalDateTime checkoutDateTime;
}
