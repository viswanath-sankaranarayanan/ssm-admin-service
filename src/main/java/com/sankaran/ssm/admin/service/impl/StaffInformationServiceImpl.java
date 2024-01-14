package com.sankaran.ssm.admin.service.impl;

import com.sankaran.ssm.admin.dtos.ApplicationConstants;
import com.sankaran.ssm.admin.dtos.LoginDetailDto;
import com.sankaran.ssm.admin.dtos.StaffInformationDto;
import com.sankaran.ssm.admin.entities.StaffInformation;
import com.sankaran.ssm.admin.mappers.impl.StaffInformationDtoToEntityMapper;
import com.sankaran.ssm.admin.mappers.impl.StaffInformationEntityToDtoMapper;
import com.sankaran.ssm.admin.repository.StaffInformationRepository;
import com.sankaran.ssm.admin.service.LoginDetailService;
import com.sankaran.ssm.admin.service.StaffInformationService;
import com.sankaran.ssm.admin.utils.SSMUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StaffInformationServiceImpl implements StaffInformationService {

    @Autowired
    StaffInformationRepository staffInformationRepository;

    @Autowired
    StaffInformationEntityToDtoMapper staffInformationEntityToDtoMapper;

    @Autowired
    StaffInformationDtoToEntityMapper staffInformationDtoToEntityMapper;

    @Autowired
    LoginDetailService loginUserManagerService;

    @Override
    public List<StaffInformationDto> getTutorInformations(){
        List<StaffInformation> staffInformations = staffInformationRepository.getTutorList();
        return staffInformationEntityToDtoMapper.convert(staffInformations);
    }

    /**
     * @return
     */
    @Override
    public List<StaffInformationDto> getAllStaffDetails() {
        List<StaffInformation> staffInformations = staffInformationRepository.findAllActive();
        return staffInformationEntityToDtoMapper.convert(staffInformations);
    }

    /**
     * @param staffInformationDto
     * @return
     */
    @Override
    public String saveStaffDetail(StaffInformationDto staffInformationDto) {
        StaffInformation staffInformation = staffInformationDtoToEntityMapper.convert(staffInformationDto);
        Boolean isExistingStaffDetail = updateStaffDetail(staffInformation);
        StaffInformation savedStaffInfo = staffInformationRepository.saveAndFlush(staffInformation);
        if (isExistingStaffDetail){
            return ApplicationConstants.STAFF_INFO_UPDATE_SUCCESS_MSG;
        }else {
            createLoginDetail(savedStaffInfo);
            return ApplicationConstants.STAFF_INFO_ADD_SUCCESS_MSG;
        }
    }

    private Boolean updateStaffDetail(StaffInformation staffInformation){
        if (!Objects.isNull(staffInformation.getStaffInfoId())){
            Optional<StaffInformation> existingStaffInformation = staffInformationRepository.findById(staffInformation.getStaffInfoId());
            if (existingStaffInformation.isPresent()){
                existingStaffInformation.get().setIsActive(false);
                existingStaffInformation.get().getPersonalInformation().setIsActive(false);
                existingStaffInformation.get().getContactDetail().setIsActive(false);
                staffInformation.setStaffInfoId(null);
                staffInformation.getPersonalInformation().setPersonalInfoId(null);
                staffInformation.getContactDetail().setContactDetailId(null);
                staffInformation.setCreatedBy(existingStaffInformation.get().getCreatedBy());
                staffInformation.setCreatedDate(existingStaffInformation.get().getCreatedDate());
                staffInformation.getPersonalInformation().setCreatedBy(existingStaffInformation.get().getPersonalInformation().getCreatedBy());
                staffInformation.getPersonalInformation().setCreatedDate(existingStaffInformation.get().getPersonalInformation().getCreatedDate());
                staffInformation.getContactDetail().setCreatedBy(existingStaffInformation.get().getContactDetail().getCreatedBy());
                staffInformation.getContactDetail().setCreatedDate(existingStaffInformation.get().getContactDetail().getCreatedDate());
                staffInformationRepository.saveAndFlush(existingStaffInformation.get());
            }
            return existingStaffInformation.isPresent();
        }else {
            generateStaffId(staffInformation);
            return false;
        }
    }

    private void generateStaffId(StaffInformation staffInformation){
        StringBuilder staffId = new StringBuilder();
        staffId.append(LocalDate.now().getYear());
        staffId.append(staffInformation.getStaffFirstName().substring(0,1).toUpperCase());
        staffId.append(staffInformation.getStaffLastName().substring(0,1).toUpperCase());
        Optional<StaffInformation> existingStaffInformation = staffInformationRepository.findFirstByIsActiveIsTrueOrderByStaffInfoIdDesc();
        if (existingStaffInformation.isPresent()){
            StringBuilder idVal = new StringBuilder();
            Long id = existingStaffInformation.get().getStaffInfoId();
            for (int i =id.toString().length() ; i<4;i++){
                idVal.append(0);
            }
            idVal.append(id);
            staffId.append(idVal);
        }else {
            staffId.append("0001");
        }
        staffInformation.setStaffId(staffId.toString());
    }

    private void createLoginDetail(StaffInformation staffInformation){
        LoginDetailDto loginDetailDto = new LoginDetailDto();
        loginDetailDto.setUserId(staffInformation.getStaffInfoId());
        loginDetailDto.setLoginUserId(staffInformation.getStaffPhoneNumber());
        loginDetailDto.setLoginPassword(SSMUtil.convertLocalDateToString(staffInformation.getDob(),
                ApplicationConstants.DATE_STRING_FORMAT));
        if (staffInformation.getStaffType() == 74)
            loginDetailDto.setRollId(1l);
        else
            loginDetailDto.setRollId(2l);
        loginDetailDto.setCreatedBy(staffInformation.getCreatedBy());
        loginDetailDto.setCreatedDate(staffInformation.getCreatedDate());
        loginDetailDto.setModifiedBy(staffInformation.getModifiedBy());
        loginDetailDto.setModifiedDate(staffInformation.getModifiedDate());
        loginDetailDto.setIsActive(true);
        loginUserManagerService.putLoginUser(loginDetailDto);
    }
}
