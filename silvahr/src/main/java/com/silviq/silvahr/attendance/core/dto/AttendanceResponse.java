package com.silviq.silvahr.attendance.core.dto;

import com.silviq.silvahr.user.staff.dto.StaffResponse;
import com.silviq.silvahr.user.staff.entity.StaffEntity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceResponse {
    private Long attendanceId;

    private StaffResponse staff;

    private LocalDate workdate;

    private LocalDateTime checkinDateTime;

    private LocalDateTime checkoutDateTime;

    private boolean isPresent;
}
