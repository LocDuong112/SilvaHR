package com.silviq.silvahr.attendance.core.repository;

import com.silviq.silvahr.attendance.core.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
}
