package com.silviq.silvahr.payroll.core.entity;

import com.silviq.silvahr.user.staff.entity.StaffEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayrollSummaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StaffEntity staff;

    @ManyToOne
    private PayrollCycleEntity payrollCycleEntity;

    private int presentDays;

    private int absentWithPayDays;

    private int absentWithoutPayDays;

    private double totalOTHours;
}
