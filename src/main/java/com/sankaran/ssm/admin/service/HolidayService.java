package com.sankaran.ssm.admin.service;

import com.sankaran.ssm.admin.dtos.HolidayDto;

import java.util.Date;
import java.util.List;

public interface HolidayService {

    List<HolidayDto> getCurrentYearHolidayList();

}
