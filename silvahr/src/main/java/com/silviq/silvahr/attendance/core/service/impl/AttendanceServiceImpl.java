package com.silviq.silvahr.attendance.core.service.impl;

import com.silviq.silvahr.attendance.core.dto.AttendanceRequest;
import com.silviq.silvahr.attendance.core.dto.AttendanceResponse;
import com.silviq.silvahr.attendance.core.service.AttendanceService;

public class AttendanceServiceImpl implements AttendanceService {
    // TODO: Implement this
    @Override
    public AttendanceResponse employeeCheckin(AttendanceRequest attendanceRequest) {
        // 1. Check staff id exist in system?
        // 2. Check valid workdate, checkinDateTime format
        // 3. Check if already checkin, take the earliest checkin time
        // 4. Create checkin request
        // 5. Add document
        // 6. Notify via mail, phone?
        return null;
    }
}
