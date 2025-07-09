package com.silviq.silvahr.user.staff.mapper;

import com.silviq.silvahr.user.staff.dto.StaffRequest;
import com.silviq.silvahr.user.staff.dto.StaffResponse;
import com.silviq.silvahr.user.staff.entity.StaffEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class StaffMapperImpl implements StaffMapper {
    /**
     * @param staffRequest 
     * @return
     */
    @Override
    public StaffEntity requestToEntity(StaffRequest staffRequest) {
        return null;
    }

    /**
     * @param staffEntity 
     * @return
     */
    @Override
    public StaffRequest entityToRequest(StaffEntity staffEntity) {
        return null;
    }

    /**
     * @param staffResponse 
     * @return
     */
    @Override
    public StaffEntity responseToEntity(StaffResponse staffResponse) {
        return null;
    }

    /**
     * @param staffEntity 
     * @return
     */
    @Override
    public StaffResponse entityToResponse(StaffEntity staffEntity) {
        return StaffResponse.builder()
                .id(staffEntity.getId())
                .staffType(staffEntity.getStaffType())
                .staffStatus(staffEntity.getStaffStatus())
                .staffName(staffEntity.getStaffName())
                .staffDOB(staffEntity.getStaffDOB())
                .onboardDate(staffEntity.getOnboardDate())
                .lastWorkingDate(staffEntity.getLastWorkingDate())
                .phoneNumber(staffEntity.getPhoneNumber())
                .avatarUrl(staffEntity.getAvatarUrl())
                .staffInternalId(staffEntity.getStaffInternalId())
                .baseSalary(staffEntity.getBaseSalary())
                .userId(staffEntity.getUser().getId())
                .build();
    }
}
