package com.silviq.silvahr.form.leave.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leave_form_type")
public class LeaveFormTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "leaveFormTypeEntity", cascade = CascadeType.ALL)
    private List<LeaveFormEntity> leaveFormEntityList;
}
