package com.silviq.silvahr.form.overtime.entity;

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
@Table(name = "overtime_form")
public class OvertimeFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private FormEntity form;

    private String reason;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @ManyToOne
    private OvertimeTypeEntity overtimeTypeEntity;
}
