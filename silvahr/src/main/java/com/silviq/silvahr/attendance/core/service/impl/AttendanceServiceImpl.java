package com.silviq.silvahr.attendance.core.service.impl;

import com.silviq.silvahr.attendance.core.dto.AttendanceRequest;
import com.silviq.silvahr.attendance.core.dto.AttendanceResponse;
import com.silviq.silvahr.attendance.core.entity.AttendanceEntity;
import com.silviq.silvahr.attendance.core.repository.AttendanceRepository;
import com.silviq.silvahr.attendance.core.service.AttendanceService;
import com.silviq.silvahr.user.staff.entity.StaffEntity;
import com.silviq.silvahr.user.staff.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Slf4j
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    // TODO: Implement this
    @Override
    public AttendanceResponse employeeCheckin(AttendanceRequest attendanceRequest) throws Exception {
        // 1. Check staff id exist in system?
        Optional<StaffEntity> optionalStaff = staffRepository.findById(attendanceRequest.getStaffId());
        if (optionalStaff.isEmpty()) {
            log.info("Staff id={} is not available!", attendanceRequest.getStaffId());
            throw new Exception("Staff id is not available!");
        }

        // 2. Check valid workdate, checkinDateTime format
        if (!isWithinToday(attendanceRequest.getCheckinDateTime())) {
            log.info("Checkin time={} is not within today!", attendanceRequest.getCheckinDateTime());
            throw new Exception("Checkin time is not within today!");
        }

        // 3. Check if already checkin, take the earliest checkin time
        Optional<AttendanceEntity> optionalAttendanceEntity = attendanceRepository.findExistingCheckin(optionalStaff.get().getId(), LocalDate.now());
        if (optionalAttendanceEntity.isPresent()) {
            attendanceRequest.setCheckinDateTime(attendanceRequest.getCheckinDateTime().isBefore(optionalAttendanceEntity.get().getCheckinDateTime()) ? attendanceRequest.getCheckinDateTime() : optionalAttendanceEntity.get().getCheckinDateTime());
        }

        // 4. Create checkin request
        AttendanceEntity tmpAttendance = new AttendanceEntity();
        tmpAttendance.builder()
                .id(optionalAttendanceEntity.map(AttendanceEntity::getId).orElse(null))
                .checkinDateTime(attendanceRequest.getCheckinDateTime())
                .workdate(LocalDate.now())
                .isPresent(true)
                .build();
        attendanceRepository.save(tmpAttendance);

        // 5. Add document
        // 6. Notify via mail
        return null;
    }

    private boolean isWithinToday(LocalDateTime checkin) {
        LocalDate today = LocalDate.now(); // Or use a fixed zone if needed

        LocalDateTime startOfDay = today.atStartOfDay(); // 00:00
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX); // 23:59:59.999999999

        return !checkin.isBefore(startOfDay) && !checkin.isAfter(endOfDay);
    }
}
