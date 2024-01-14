package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.HolidayDto;
import com.sankaran.ssm.admin.entities.Holidays;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import com.sankaran.ssm.admin.utils.SSMUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HolidaysEntityToDtoMapperImpl implements DtoEntityMapper<Holidays, HolidayDto> {
    @Override
    public HolidayDto convert(Holidays source) {
        HolidayDto holidayDto = new HolidayDto(source.getHolidayId(), source.getHolidayYear(), source.getHolidayType().getCodeDescription(),
                source.getHolidayDate(), SSMUtil.convertLocalDateToString(source.getHolidayDate(),SSMUtil.ymdFormat));
        holidayDto.setCreatedBy(source.getCreatedBy());
        holidayDto.setCreatedDate(source.getCreatedDate());
        holidayDto.setCreatedDateStr(String.valueOf(source.getCreatedDate()));
        holidayDto.setModifiedBy(source.getModifiedBy());
        holidayDto.setModifiedDate(source.getModifiedDate());
        holidayDto.setModifiedDateStr(String.valueOf(source.getModifiedDate()));
        return holidayDto;
    }

    @Override
    public List<HolidayDto> convert(List<Holidays> sourceList) {
        return sourceList.stream().map(source -> {
            HolidayDto holidayDto = new HolidayDto(source.getHolidayId(), source.getHolidayYear(), source.getHolidayType().getCodeDescription(),
                    source.getHolidayDate(), SSMUtil.convertLocalDateToString(source.getHolidayDate(),SSMUtil.ymdFormat));
            holidayDto.setCreatedBy(source.getCreatedBy());
            holidayDto.setCreatedDate(source.getCreatedDate());
            holidayDto.setCreatedDateStr(String.valueOf(source.getCreatedDate()));
            holidayDto.setModifiedBy(source.getModifiedBy());
            holidayDto.setModifiedDate(source.getModifiedDate());
            holidayDto.setModifiedDateStr(String.valueOf(source.getModifiedDate()));
            return holidayDto;
        }).collect(Collectors.toList());
    }
}
