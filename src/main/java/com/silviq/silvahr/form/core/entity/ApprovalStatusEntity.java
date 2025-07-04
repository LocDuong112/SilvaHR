package com.silviq.silvahr.form.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "approval_status")
public class ApprovalStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @OneToMany(mappedBy = "approvalStatusEntity", cascade = CascadeType.ALL)
    private List<FormApprovalLogEntity> formApprovalLogEntityList;
}
