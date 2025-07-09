package com.silviq.silvahr.attendance.core.service.impl;

import com.silviq.silvahr.attendance.core.dto.AttendanceRequest;
import com.silviq.silvahr.attendance.core.dto.AttendanceResponse;
import com.silviq.silvahr.attendance.core.entity.AttendanceEntity;
import com.silviq.silvahr.attendance.core.mapper.AttendanceMapper;
import com.silviq.silvahr.attendance.core.repository.AttendanceRepository;
import com.silviq.silvahr.attendance.core.service.AttendanceService;
import com.silviq.silvahr.user.staff.dto.StaffResponse;
import com.silviq.silvahr.user.staff.entity.StaffEntity;
import com.silviq.silvahr.user.staff.mapper.StaffMapper;
import com.silviq.silvahr.user.staff.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Slf4j
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private AttendanceMapper attendanceMapper;
    
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public AttendanceResponse employeeCheckin(AttendanceRequest attendanceRequest) throws Exception {
        AttendanceResponse attendanceResponse;
        if (attendanceRequest.getStaffId() <= 0L || attendanceRequest.getCheckinDateTime() == null) {
            log.info("attendanceRequest = {}", attendanceRequest);
            throw new Exception("Check your request!");
        }

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
        optionalAttendanceEntity.ifPresent(attendanceEntity -> attendanceRequest.setCheckinDateTime(attendanceRequest.getCheckinDateTime().isBefore(attendanceEntity.getCheckinDateTime()) ? attendanceRequest.getCheckinDateTime() : attendanceEntity.getCheckinDateTime()));

        // 4. Create checkin request
        AttendanceEntity tmpAttendance = attendanceMapper.requestToEntity(attendanceRequest);
        tmpAttendance.setId(optionalAttendanceEntity.map(AttendanceEntity::getId).orElse(null));
        tmpAttendance.setWorkdate(LocalDate.now());
        tmpAttendance.setPresent(true);
        tmpAttendance.setCheckoutDateTime(null);

        tmpAttendance = attendanceRepository.save(tmpAttendance);

        attendanceResponse = attendanceMapper.entityToResponse(tmpAttendance);

        // 5. Add document
        // TODO: Do in Controller of the Document

        // 6. Notify via mail
        // TODO: Later on

        return attendanceResponse;
    }

    @Override
    public AttendanceResponse employeeCheckout(AttendanceRequest attendanceRequest) throws Exception {
        AttendanceResponse attendanceResponse;
        if (attendanceRequest.getStaffId() <= 0L || attendanceRequest.getCheckoutDateTime() == null) {
            log.info("attendanceRequest = {}", attendanceRequest);
            throw new Exception("Check your request!");
        }

        // 1. Check staff id exist in system?
        Optional<StaffEntity> optionalStaff = staffRepository.findById(attendanceRequest.getStaffId());
        if (optionalStaff.isEmpty()) {
            log.info("Staff id={} is not available!", attendanceRequest.getStaffId());
            throw new Exception("Staff id is not available!");
        }

        // 2. Check valid workdate, checkoutDateTime format
        if (!isWithinToday(attendanceRequest.getCheckoutDateTime())) {
            log.info("Checkout time={} is not within today!", attendanceRequest.getCheckoutDateTime());
        }

        // 3. Check if already checkout, take the latest checkout time
        Optional<AttendanceEntity> optionalAttendanceEntity = attendanceRepository.findExistingCheckin(optionalStaff.get().getId(), LocalDate.now());
        if (optionalAttendanceEntity.isPresent() && optionalAttendanceEntity.get().getCheckoutDateTime() != null) {
            optionalAttendanceEntity.ifPresent(attendanceEntity -> attendanceRequest.setCheckoutDateTime(attendanceRequest.getCheckoutDateTime().isAfter(attendanceEntity.getCheckoutDateTime()) ? attendanceRequest.getCheckoutDateTime() : attendanceEntity.getCheckoutDateTime()));
        }

        // 4. Create checkout request
        AttendanceEntity tmpAttendance = attendanceMapper.requestToEntity(attendanceRequest);
        tmpAttendance.setId(optionalAttendanceEntity.map(AttendanceEntity::getId).orElse(null));
        tmpAttendance.setWorkdate(optionalAttendanceEntity.map(AttendanceEntity::getWorkdate).orElse(LocalDate.now()));
        tmpAttendance.setPresent(true);
        tmpAttendance.setCheckinDateTime(optionalAttendanceEntity.map(AttendanceEntity::getCheckinDateTime).orElse(null));

        tmpAttendance = attendanceRepository.save(tmpAttendance);

        attendanceResponse = attendanceMapper.entityToResponse(tmpAttendance);

        // 5. Add document
        // TODO: Do in Controller of the Document

        // 6. Notify via mail
        // TODO: Later on

        return attendanceResponse;
    }

    private boolean isWithinToday(LocalDateTime inputDateTime) throws Exception {
        LocalDateTime now = LocalDateTime.now();

        LocalDate today = LocalDate.now();
        LocalDate inputDate = inputDateTime.toLocalDate();
        if (inputDate.isBefore(today.minusDays(1)) || inputDate.isAfter(today.plusDays(2))) {
            log.info("Input day={} is before or after 1 day or more!", inputDateTime);
            throw new Exception("Input day is before or after 1 day or more!");
        }

        return !inputDateTime.isAfter(now) && inputDateTime.toLocalDate().isEqual(now.toLocalDate());
    }
}
