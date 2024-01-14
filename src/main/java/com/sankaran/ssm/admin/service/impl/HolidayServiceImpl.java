package com.sankaran.ssm.admin.service.impl;

import com.sankaran.ssm.admin.dtos.HolidayDto;
import com.sankaran.ssm.admin.entities.Holidays;
import com.sankaran.ssm.admin.mappers.impl.HolidaysEntityToDtoMapperImpl;
import com.sankaran.ssm.admin.repository.HolidayRepository;
import com.sankaran.ssm.admin.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    HolidaysEntityToDtoMapperImpl holidaysEntityToDtoMapper;
    @Override
    public List<HolidayDto> getCurrentYearHolidayList() {
        List<Holidays> holidaysList = holidayRepository.findByHolidayYearOrderByHolidayDate(String.valueOf(LocalDate.now().getYear()));
        return holidaysEntityToDtoMapper.convert(holidaysList);
    }

}
