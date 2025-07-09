package com.silviq.silvahr.user.staff.dto;

import com.silviq.silvahr.user.staff.entity.StaffStatus;
import com.silviq.silvahr.user.staff.entity.StaffType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffRequest {
    private StaffType staffType;

    private StaffStatus staffStatus;

    private String staffName;

    private LocalDate staffDOB;

    private LocalDate onboardDate;

    private LocalDate lastWorkingDate;

    private String phoneNumber;

    private String avatarUrl;

    private String staffInternalId;

    private float baseSalary;
}
