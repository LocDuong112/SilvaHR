package com.silviq.silvahr.attendance.core.repository;

import com.silviq.silvahr.attendance.core.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
    @Query(""" 
            SELECT a FROM AttendanceEntity a
            WHERE 1=1
            AND a.staff.id = :staffId
            AND a.workdate = :workdate
            AND a.checkinDateTime IS NOT NULL
            AND a.isPresent = TRUE
            """)
    Optional<AttendanceEntity> findExistingCheckin(@Param("staffId") long staffId, @Param("workdate") LocalDate workdate);
}
