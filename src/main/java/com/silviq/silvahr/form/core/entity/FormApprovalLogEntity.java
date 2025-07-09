package com.silviq.silvahr.form.core.entity;

import com.silviq.silvahr.user.staff.entity.StaffEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "form_approval_log")
public class FormApprovalLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StaffEntity staff;

    @ManyToOne
    private FormEntity form;

    private String description;

    @ManyToOne
    private ApprovalStatusEntity approvalStatusEntity;

    private int step;
}
