package com.silviq.silvahr.form.leave.entity;

import com.silviq.silvahr.form.core.entity.FormEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leave_form")
public class LeaveFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String leaveReason;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @ManyToOne
    private LeaveFormTypeEntity leaveFormTypeEntity;

    @OneToOne(cascade = CascadeType.ALL)
    private FormEntity form;
}
