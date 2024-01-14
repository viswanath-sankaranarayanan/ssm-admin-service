package com.sankaran.ssm.admin.service;

import com.sankaran.ssm.admin.dtos.ChartDto;

import java.util.List;

public interface ChartService {

    List<ChartDto> getStudentChart();

    List<ChartDto> getStaffCountChart();
}
