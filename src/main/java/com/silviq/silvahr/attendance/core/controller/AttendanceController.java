package com.silviq.silvahr.attendance.core.controller;

import com.silviq.silvahr.attendance.core.dto.AttendanceRequest;
import com.silviq.silvahr.attendance.core.dto.AttendanceResponse;
import com.silviq.silvahr.attendance.core.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/checkin")
    public AttendanceResponse employeeCheckin(@RequestBody AttendanceRequest attendanceRequest) throws Exception {
        return attendanceService.employeeCheckin(attendanceRequest);
    }

    @PostMapping("/checkout")
    public AttendanceResponse employeeCheckout(@RequestBody AttendanceRequest attendanceRequest) throws Exception {
        return attendanceService.employeeCheckout(attendanceRequest);
    }
}
