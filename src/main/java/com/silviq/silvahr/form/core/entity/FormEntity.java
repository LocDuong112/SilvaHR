package com.silviq.silvahr.form.core.entity;

import com.silviq.silvahr.form.leave.entity.LeaveFormEntity;
import com.silviq.silvahr.form.overtime.entity.OvertimeFormEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "form")
public class FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formName;

    private String formDescription;

    private Long requestStaffId;

    @ManyToOne
    private FormStatusEntity formStatusEntity;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<FormApprovalLogEntity> formApprovalLogEntityList;

    @OneToOne(mappedBy = "form")
    private LeaveFormEntity leaveFormEntity;

    @OneToOne(mappedBy = "form")
    private OvertimeFormEntity overtimeFormEntity;
}
