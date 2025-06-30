package com.silviq.silvahr.payroll.core.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payroll_working_day")
public class PayrollWorkingDayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PayrollCycleEntity payrollCycleEntity;

    private LocalDate workdate;
}
