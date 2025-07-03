package com.silviq.silvahr.attendance.core.mapper;

import com.silviq.silvahr.attendance.core.dto.AttendanceRequest;
import com.silviq.silvahr.attendance.core.dto.AttendanceResponse;
import com.silviq.silvahr.attendance.core.entity.AttendanceEntity;

public interface AttendanceMapper {
    AttendanceEntity requestToEntity(AttendanceRequest attendanceRequest) throws Exception;
    AttendanceRequest entityToRequest(AttendanceEntity attendanceEntity);
    AttendanceEntity responseToEntity(AttendanceResponse attendanceResponse);
    AttendanceResponse entityToResponse(AttendanceEntity attendanceEntity);
}
