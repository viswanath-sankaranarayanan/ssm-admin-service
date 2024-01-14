package com.sankaran.ssm.admin.service;

import com.sankaran.ssm.admin.dtos.StaffInformationDto;

import java.util.List;

public interface StaffInformationService {
    List<StaffInformationDto> getTutorInformations();

    List<StaffInformationDto> getAllStaffDetails();

    String saveStaffDetail(StaffInformationDto staffInformationDto);
}
