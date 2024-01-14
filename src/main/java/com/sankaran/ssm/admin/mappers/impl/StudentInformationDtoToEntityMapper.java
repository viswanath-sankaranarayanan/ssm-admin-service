package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.StudentInformationDto;
import com.sankaran.ssm.admin.entities.StudentInformation;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentInformationDtoToEntityMapper implements DtoEntityMapper<StudentInformationDto, StudentInformation> {

    @Autowired
    PersonalInformationDtoToEntityMapper personalInformationDtoToEntityMapper;

    @Autowired
    ContactDetailDtoToEntityMapper contactDetailDtoToEntityMapper;

    /**
     * @param source
     * @return
     */
    @Override
    public StudentInformation convert(StudentInformationDto source) {
        StudentInformation studentInformation = new StudentInformation(source.getStudentInfoId(), source.getStudentRollNumber(), source.getStudentFirstName(),
                source.getStudentMiddleName(), source.getStudentLastName(), source.getGender(), source.getBloodGroup(), source.getDob(),
                personalInformationDtoToEntityMapper.convert(source.getPersonalInformation()),
                contactDetailDtoToEntityMapper.convert(source.getContactDetail()));
        studentInformation.setCreatedBy(source.getCreatedBy());
        studentInformation.setCreatedDate(LocalDateTime.now());
        studentInformation.setModifiedBy(source.getModifiedBy());
        studentInformation.setModifiedDate(LocalDateTime.now());
        studentInformation.setIsActive(true);
        return studentInformation;
    }

    /**
     * @param sourceList
     * @return
     */
    @Override
    public List<StudentInformation> convert(List<StudentInformationDto> sourceList) {
        return sourceList.stream().map(source -> {
            StudentInformation studentInformation = new StudentInformation(source.getStudentInfoId(), source.getStudentRollNumber(), source.getStudentFirstName(),
                    source.getStudentMiddleName(), source.getStudentLastName(), source.getGender(), source.getBloodGroup(), source.getDob(),
                    personalInformationDtoToEntityMapper.convert(source.getPersonalInformation()),
                    contactDetailDtoToEntityMapper.convert(source.getContactDetail()));
            studentInformation.setCreatedBy(source.getCreatedBy());
            studentInformation.setCreatedDate(LocalDateTime.now());
            studentInformation.setModifiedBy(source.getModifiedBy());
            studentInformation.setModifiedDate(LocalDateTime.now());
            studentInformation.setIsActive(true);
            return studentInformation;
        }).collect(Collectors.toList());
    }
}
