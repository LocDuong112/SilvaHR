package com.silviq.silvahr.user.staff.entity;

import com.silviq.silvahr.attendance.core.entity.AttendanceEntity;
import com.silviq.silvahr.document.core.entity.DocumentEntity;
import com.silviq.silvahr.form.core.entity.FormApprovalLogEntity;
import com.silviq.silvahr.payroll.core.entity.PayrollSummaryEntity;
import com.silviq.silvahr.user.core.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StaffType staffType;

    @Enumerated(EnumType.STRING)
    private StaffStatus staffStatus;

    private String staffName;

    private LocalDate staffDOB;

    private LocalDate onboardDate;

    private LocalDate lastWorkingDate;

    private String phoneNumber;

    private String avatarUrl;

    private String staffInternalId;

    @OneToOne(mappedBy = "staff")
    private UserEntity user;

    private float baseSalary;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<FormApprovalLogEntity> formApprovalLogEntityList;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<AttendanceEntity> attendanceEntityList;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<PayrollSummaryEntity> payrollSummaryEntityList;
}
