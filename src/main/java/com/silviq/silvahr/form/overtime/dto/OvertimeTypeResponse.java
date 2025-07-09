package com.silviq.silvahr.form.overtime.dto;

import lombok.*;

import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OvertimeTypeResponse {
    private Long id;

    private String OTType;

    private double payMultiplier;

    private LocalTime startTime;

    private LocalTime endTime;
}
