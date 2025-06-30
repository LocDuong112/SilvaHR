package com.silviq.silvahr.attendance.core.entity;

import com.silviq.silvahr.document.core.entity.DocumentEntity;
import com.silviq.silvahr.user.staff.entity.StaffEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attendance")
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StaffEntity staff;

    private LocalDate workdate;

    private LocalDateTime checkinDateTime;

    private LocalDateTime checkoutDateTime;

    private boolean isPresent;
}
