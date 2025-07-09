package com.silviq.silvahr.document.core.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "document")
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentName;

    private String documentDescription;

    private String documentUrl;

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    private Long entityId;

}
