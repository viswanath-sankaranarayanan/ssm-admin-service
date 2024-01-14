package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.PersonalInformationDto;
import com.sankaran.ssm.admin.dtos.StaffInformationDto;
import com.sankaran.ssm.admin.entities.StaffInformation;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StaffInformationEntityToDtoMapper implements DtoEntityMapper<StaffInformation, StaffInformationDto> {
    @Autowired
    PersonalInformationEntityToDtoMapper personalInformationEntityToDtoMapper;

    @Autowired
    CodeMasterEntityToDtoMapper codeMasterEntityToDtoMapper;

    @Autowired
    ContactDetailEntityToDtoMapper contactDetailEntityToDtoMapper;

    /**
     * @param source
     * @return
     */
    @Override
    public StaffInformationDto convert(StaffInformation source) {
        String staffFullName = String.join(" ",Optional.ofNullable(source.getStaffFirstName()).orElse(""),
                Optional.ofNullable(source.getStaffMiddleName()).orElse(""),
                Optional.ofNullable(source.getStaffLastName()).orElse(""));
        StaffInformationDto staffInformationDto = new StaffInformationDto(source.getStaffInfoId(), source.getStaffId(), source.getStaffFirstName(),
                source.getStaffMiddleName(), source.getStaffLastName(), StringUtils.normalizeSpace(staffFullName),
                source.getStaffPhoneNumber(), source.getStaffEmailId(), source.getDob(), source.getGender(),
                source.getBloodGroup(), source.getStaffType(),
                codeMasterEntityToDtoMapper.convert(source.getStaffTypeCode()),
                Optional.ofNullable(source.getPersonalInformation()).isPresent()?personalInformationEntityToDtoMapper.convert(source.getPersonalInformation()):null,
                Optional.ofNullable(source.getContactDetail()).isPresent()?contactDetailEntityToDtoMapper.convert(source.getContactDetail()):null);
        staffInformationDto.setCreatedBy(source.getCreatedBy());
        staffInformationDto.setCreatedDate(source.getCreatedDate());
        staffInformationDto.setModifiedBy(source.getModifiedBy());
        staffInformationDto.setModifiedDate(source.getModifiedDate());
        return staffInformationDto;
    }

    /**
     * @param sourceList
     * @return
     */
    @Override
    public List<StaffInformationDto> convert(List<StaffInformation> sourceList) {
        return sourceList.stream().map(source -> {
            String staffFullName = String.join(" ",Optional.ofNullable(source.getStaffFirstName()).orElse(""),
                    Optional.ofNullable(source.getStaffMiddleName()).orElse(""),
                    Optional.ofNullable(source.getStaffLastName()).orElse(""));
            StaffInformationDto staffInformationDto = new StaffInformationDto(source.getStaffInfoId(), source.getStaffId(), source.getStaffFirstName(),
                    source.getStaffMiddleName(), source.getStaffLastName(), StringUtils.normalizeSpace(staffFullName),
                    source.getStaffPhoneNumber(), source.getStaffEmailId(), source.getDob(), source.getGender(),
                    source.getBloodGroup(), source.getStaffType(),
                    codeMasterEntityToDtoMapper.convert(source.getStaffTypeCode()),
                    Optional.ofNullable(source.getPersonalInformation()).isPresent()?personalInformationEntityToDtoMapper.convert(source.getPersonalInformation()):null,
                    Optional.ofNullable(source.getContactDetail()).isPresent()?contactDetailEntityToDtoMapper.convert(source.getContactDetail()):null);
            staffInformationDto.setCreatedBy(source.getCreatedBy());
            staffInformationDto.setCreatedDate(source.getCreatedDate());
            staffInformationDto.setModifiedBy(source.getModifiedBy());
            staffInformationDto.setModifiedDate(source.getModifiedDate());
            return staffInformationDto;
        }).collect(Collectors.toList());
    }
}
