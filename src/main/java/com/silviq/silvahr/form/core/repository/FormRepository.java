package com.silviq.silvahr.form.core.repository;

import com.silviq.silvahr.form.core.entity.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface FormRepository extends JpaRepository<FormEntity, Long> {

    @Query("""
            SELECT f FROM FormEntity f
            WHERE 1=1
            AND f.requestStaffId = :requestStaffId
            AND f.leaveFormEntity.startDateTime = :startDateTime
            AND f.leaveFormEntity.endDateTime = :endDateTime
            """)
    Optional<FormEntity> findSickLeave(@Param("requestStaffId") long requestStaffId,
                                       @Param("startDateTime") LocalDateTime startDateTime,
                                       @Param("endDateTime") LocalDateTime endDateTime);
}
