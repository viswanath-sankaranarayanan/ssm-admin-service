package com.sankaran.ssm.admin.service;

import com.sankaran.ssm.admin.dtos.StudentInformationDto;

import java.util.List;

public interface StudentInformationService {

    List<StudentInformationDto> getStudentDetails();

    List<StudentInformationDto> filterStudentDetails(String filterValue);

    String saveStudentInformation(StudentInformationDto studentInformationDto);
}
