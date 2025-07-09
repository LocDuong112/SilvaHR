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
@Table(name = "form_status")
public class FormStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @OneToMany(mappedBy = "formStatusEntity", cascade = CascadeType.ALL)
    private List<FormEntity> formEntityList;
}
