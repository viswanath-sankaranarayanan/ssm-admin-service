package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.StudentInformationDto;
import com.sankaran.ssm.admin.entities.StudentInformation;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentInformationEntityToDtoMapper implements DtoEntityMapper<StudentInformation, StudentInformationDto> {

    @Autowired
    PersonalInformationEntityToDtoMapper personalInformationEntityToDtoMapper;

    @Autowired
    ContactDetailEntityToDtoMapper contactDetailEntityToDtoMapper;

    @Override
    public StudentInformationDto convert(StudentInformation source) {
        return new StudentInformationDto(source.getStudentInfoId(), source.getStudentRollNumber(),
                source.getStudentFirstName(), source.getStudentMiddleName(), source.getStudentLastName(),
                source.getGender(), source.getBloodGroup(), source.getDob(),
                personalInformationEntityToDtoMapper.convert(source.getPersonalInformation()),
                contactDetailEntityToDtoMapper.convert(source.getContactDetail()));
    }

    @Override
    public List<StudentInformationDto> convert(List<StudentInformation> sourceList) {
        return sourceList.stream().map(source -> {
            return new StudentInformationDto(source.getStudentInfoId(), source.getStudentRollNumber(),
                    source.getStudentFirstName(), source.getStudentMiddleName(), source.getStudentLastName(),
                    source.getGender(), source.getBloodGroup(), source.getDob(),
                    personalInformationEntityToDtoMapper.convert(source.getPersonalInformation()),
                    contactDetailEntityToDtoMapper.convert(source.getContactDetail()));
        }).collect(Collectors.toList());
    }
}
