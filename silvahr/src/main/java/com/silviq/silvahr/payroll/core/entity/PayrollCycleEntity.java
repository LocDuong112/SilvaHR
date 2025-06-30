package com.silviq.silvahr.payroll.core.entity;

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
@Table(name = "payroll_cycle")
public class PayrollCycleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fromDate;

    private LocalDate toDate;

    private int totalWorkingDays;

    @OneToMany(mappedBy = "payrollCycleEntity", cascade = CascadeType.ALL)
    private List<PayrollWorkingDayEntity> listPayrollWorkingDayEntity;

    @OneToMany(mappedBy = "payrollCycleEntity", cascade = CascadeType.ALL)
    private List<PayrollSummaryEntity> payrollSummaryEntityList;
}
