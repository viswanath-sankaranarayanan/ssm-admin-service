package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.StaffInformationDto;
import com.sankaran.ssm.admin.entities.StaffInformation;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffInformationDtoToEntityMapper implements DtoEntityMapper<StaffInformationDto, StaffInformation> {
    @Autowired
    PersonalInformationDtoToEntityMapper personalInformationDtoToEntityMapper;

    @Autowired
    CodeMasterDtoToEntityMapper codeMasterDtoToEntityMapper;

    @Autowired
    ContactDetailDtoToEntityMapper contactDetailDtoToEntityMapper;
    /**
     * @param source
     * @return
     */
    @Override
    public StaffInformation convert(StaffInformationDto source) {
        StaffInformation staffInformation = new StaffInformation(source.getStaffInfoId(), source.getStaffId(),
                source.getStaffFirstName(), source.getStaffMiddleName(), source.getStaffLastName(),
                source.getStaffPhoneNumber(), source.getStaffEmailId(), source.getDob(), source.getGender(),
                source.getBloodGroup(), source.getStaffType(), null,
                personalInformationDtoToEntityMapper.convert(source.getPersonalInformation()),
                contactDetailDtoToEntityMapper.convert(source.getContactDetail()));
        staffInformation.setIsActive(true);
        staffInformation.setCreatedBy(source.getCreatedBy());
        staffInformation.setCreatedDate(LocalDateTime.now());
        staffInformation.setModifiedBy(source.getModifiedBy());
        staffInformation.setModifiedDate(LocalDateTime.now());
        return staffInformation;
    }

    /**
     * @param sourceList
     * @return
     */
    @Override
    public List<StaffInformation> convert(List<StaffInformationDto> sourceList) {
        return sourceList.stream().map(source -> {
            StaffInformation staffInformation = new StaffInformation(source.getStaffInfoId(), source.getStaffId(),
                    source.getStaffFirstName(), source.getStaffMiddleName(), source.getStaffLastName(),
                    source.getStaffPhoneNumber(), source.getStaffEmailId(), source.getDob(), source.getGender(),
                    source.getBloodGroup(), source.getStaffType(), null,
                    personalInformationDtoToEntityMapper.convert(source.getPersonalInformation()),
                    contactDetailDtoToEntityMapper.convert(source.getContactDetail()));
            staffInformation.setIsActive(true);
            staffInformation.setCreatedBy(source.getCreatedBy());
            staffInformation.setCreatedDate(LocalDateTime.now());
            staffInformation.setModifiedBy(source.getModifiedBy());
            staffInformation.setModifiedDate(LocalDateTime.now());
            return staffInformation;
        }).collect(Collectors.toList());
    }
}
