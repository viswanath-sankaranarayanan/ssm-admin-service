package com.sankaran.ssm.admin.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentAttendanceDto {
    private Long stAttendanceId;
    private StudentInformationDto studentInformationDto;
    private StaffInformationDto staffInformationDto;
    private Boolean isPresent;
    private LocalDateTime attendanceDate;
}
