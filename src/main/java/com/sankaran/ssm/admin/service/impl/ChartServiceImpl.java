package com.sankaran.ssm.admin.service.impl;

import com.sankaran.ssm.admin.dtos.ChartDto;
import com.sankaran.ssm.admin.repository.ChartRepository;
import com.sankaran.ssm.admin.service.ChartService;
import com.sankaran.ssm.admin.utils.SSMUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ChartServiceImpl implements ChartService {

    @Autowired
    ChartRepository chartRepository;

    @Override
    public List<ChartDto> getStudentChart() {
        List<Object[]> studentAttendanceCounts = chartRepository.getStudentAttendanceCount(SSMUtil.getCurrentDateString());
        List<ChartDto> chartDtos = studentAttendanceCounts.stream().map(obj -> {
            return new ChartDto(SSMUtil.ObjectToString(obj[0]), SSMUtil.ObjectToLong(obj[1]));
        }).collect(Collectors.toList());
        return chartDtos;
    }

    @Override
    public List<ChartDto> getStaffCountChart() {
        List<Object[]> staffCountList = chartRepository.getStaffCount();
        List<ChartDto> chartDtos = staffCountList.stream().map(obj -> {
            return new ChartDto(SSMUtil.ObjectToString(obj[1]), SSMUtil.ObjectToLong(obj[2]));
        }).collect(Collectors.toList());
        return chartDtos;
    }
}
