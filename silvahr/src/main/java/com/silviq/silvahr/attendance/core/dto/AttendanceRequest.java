package com.silviq.silvahr.attendance.core.dto;

import com.silviq.silvahr.user.staff.entity.StaffEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceRequest {
    private Long staffId;

    private LocalDate workdate;

    private LocalDateTime checkinDateTime;

    private LocalDateTime checkoutDateTime;
}
