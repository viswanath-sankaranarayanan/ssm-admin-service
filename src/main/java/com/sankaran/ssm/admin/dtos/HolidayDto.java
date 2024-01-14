package com.sankaran.ssm.admin.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HolidayDto extends SuperDto{

    private Long holidayId;
    private String holidayYear;
    private String holidayType;
    private LocalDate holidayDate;
    private String holidayDateStr;
}
