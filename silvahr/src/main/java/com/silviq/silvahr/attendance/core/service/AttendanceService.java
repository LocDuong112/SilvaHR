package com.silviq.silvahr.attendance.core.service;

import com.silviq.silvahr.attendance.core.dto.AttendanceRequest;
import com.silviq.silvahr.attendance.core.dto.AttendanceResponse;
import com.silviq.silvahr.attendance.core.entity.AttendanceEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface AttendanceService {
    public AttendanceResponse employeeCheckin(AttendanceRequest attendanceRequest);
}
