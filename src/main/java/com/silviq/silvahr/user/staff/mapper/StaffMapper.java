package com.silviq.silvahr.user.staff.mapper;

import com.silviq.silvahr.user.staff.dto.StaffRequest;
import com.silviq.silvahr.user.staff.dto.StaffResponse;
import com.silviq.silvahr.user.staff.entity.StaffEntity;

public interface StaffMapper {
    StaffEntity requestToEntity(StaffRequest staffRequest);
    StaffRequest entityToRequest(StaffEntity staffEntity);
    StaffEntity responseToEntity(StaffResponse staffResponse);
    StaffResponse entityToResponse(StaffEntity staffEntity);
}
