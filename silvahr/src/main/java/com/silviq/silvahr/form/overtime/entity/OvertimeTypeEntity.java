package com.silviq.silvahr.form.overtime.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "overtime_type")
public class OvertimeTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String OTType;

    private double payMultiplier;

    private LocalTime startTime;

    private LocalTime endTime;

    @OneToMany(mappedBy = "overtimeTypeEntity", cascade = CascadeType.ALL)
    private List<OvertimeFormEntity> overtimeFormEntityList;
}
