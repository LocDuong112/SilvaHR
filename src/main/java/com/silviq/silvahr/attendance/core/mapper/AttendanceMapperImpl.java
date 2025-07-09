package com.silviq.silvahr.attendance.core.mapper;

import com.silviq.silvahr.attendance.core.dto.AttendanceRequest;
import com.silviq.silvahr.attendance.core.dto.AttendanceResponse;
import com.silviq.silvahr.attendance.core.entity.AttendanceEntity;
import com.silviq.silvahr.user.staff.dto.StaffResponse;
import com.silviq.silvahr.user.staff.entity.StaffEntity;
import com.silviq.silvahr.user.staff.mapper.StaffMapper;
import com.silviq.silvahr.user.staff.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class AttendanceMapperImpl implements AttendanceMapper {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private StaffMapper staffMapper;

    /**
     * @param attendanceRequest 
     * @return
     */
    @Override
    public AttendanceEntity requestToEntity(AttendanceRequest attendanceRequest) throws Exception {
        Optional<StaffEntity> optionalStaff = staffRepository.findById(attendanceRequest.getStaffId());

        if (optionalStaff.isEmpty()) {
            log.info("Staff id={} is not available!", attendanceRequest.getStaffId());
            throw new Exception("Staff id is not available!");
        }

        return AttendanceEntity.builder()
                .checkinDateTime(attendanceRequest.getCheckinDateTime())
                .checkoutDateTime(attendanceRequest.getCheckoutDateTime())
                .staff(optionalStaff.get())
                .build();
    }

    /**
     * @param attendanceEntity 
     * @return
     */
    @Override
    public AttendanceRequest entityToRequest(AttendanceEntity attendanceEntity) {
        return null;
    }

    /**
     * @param attendanceResponse 
     * @return
     */
    @Override
    public AttendanceEntity responseToEntity(AttendanceResponse attendanceResponse) {
        return null;
    }

    /**
     * @param attendanceEntity 
     * @return
     */
    @Override
    public AttendanceResponse entityToResponse(AttendanceEntity attendanceEntity) {

        StaffResponse staffResponse = staffMapper.entityToResponse(attendanceEntity.getStaff());

        return AttendanceResponse.builder()
                .attendanceId(attendanceEntity.getId())
                .checkinDateTime(attendanceEntity.getCheckinDateTime())
                .checkoutDateTime(attendanceEntity.getCheckoutDateTime())
                .workdate(attendanceEntity.getWorkdate())
                .isPresent(attendanceEntity.isPresent())
                .staff(staffResponse)
                .build();
    }
}
