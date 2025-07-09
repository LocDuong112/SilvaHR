package com.silviq.silvahr.user.core.entity;

import com.silviq.silvahr.user.staff.entity.StaffEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToOne
    private RoleEntity role;

    @OneToOne(cascade = CascadeType.ALL)
    private StaffEntity staff;
}
