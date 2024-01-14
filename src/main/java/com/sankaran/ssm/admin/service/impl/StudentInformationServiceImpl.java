package com.sankaran.ssm.admin.service.impl;

import com.sankaran.ssm.admin.dtos.ApplicationConstants;
import com.sankaran.ssm.admin.dtos.LoginDetailDto;
import com.sankaran.ssm.admin.dtos.StudentInformationDto;
import com.sankaran.ssm.admin.entities.StudentInformation;
import com.sankaran.ssm.admin.mappers.impl.StudentInformationDtoToEntityMapper;
import com.sankaran.ssm.admin.mappers.impl.StudentInformationEntityToDtoMapper;
import com.sankaran.ssm.admin.repository.PersonalInformationRepository;
import com.sankaran.ssm.admin.repository.StudentInformationRepository;
import com.sankaran.ssm.admin.service.LoginDetailService;
import com.sankaran.ssm.admin.service.StudentInformationService;
import com.sankaran.ssm.admin.utils.SSMUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentInformationServiceImpl implements StudentInformationService {

    @Autowired
    private StudentInformationRepository studentInformationRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @Autowired
    private StudentInformationEntityToDtoMapper studentInformationEntityToDtoMapper;

    @Autowired
    private StudentInformationDtoToEntityMapper studentInformationDtoToEntityMapper;

    @Autowired
    private LoginDetailService loginUserManagerService;

    @Override
    public List<StudentInformationDto> getStudentDetails() {
        List<StudentInformation> studentInformations = studentInformationRepository.findAll();
        return studentInformationEntityToDtoMapper.convert(studentInformations);
    }

    /**
     * @return
     */
    @Override
    public List<StudentInformationDto> filterStudentDetails(String filterValue) {
        List<StudentInformation> studentInformations = studentInformationRepository.findStudentInformationsByFilterValue(filterValue.toUpperCase());
        return studentInformationEntityToDtoMapper.convert(studentInformations);
    }

    /**
     * @param studentInformationDto
     * @return
     */
    @Override
    @Transactional
    public String saveStudentInformation(StudentInformationDto studentInformationDto) {
        StudentInformation studentInformation = studentInformationDtoToEntityMapper.convert(studentInformationDto);
        Boolean isStudentDataPresent = updateStudentInformation(studentInformation);
        StudentInformation savedStudentInfo = studentInformationRepository.saveAndFlush(studentInformation);
        if (isStudentDataPresent){
            return ApplicationConstants.STUDENT_INFO_UPDATE_SUCCESS_MSG;
        }else {
            createLoginDetail(studentInformation);
            return ApplicationConstants.STUDENT_INFO_ADD_SUCCESS_MSG;
        }
    }

    private Boolean updateStudentInformation(StudentInformation studentInformation){
        if (!Objects.isNull(studentInformation.getStudentInfoId())){
            Optional<StudentInformation> existingStudentInformation = studentInformationRepository.findById(studentInformation.getStudentInfoId());
            if (existingStudentInformation.isPresent()){
                existingStudentInformation.get().setIsActive(false);
                studentInformation.setCreatedDate(existingStudentInformation.get().getCreatedDate());
                studentInformation.setCreatedBy(existingStudentInformation.get().getCreatedBy());
                studentInformation.setStudentInfoId(null);
                studentInformationRepository.saveAndFlush(existingStudentInformation.get());
            }
            return existingStudentInformation.isPresent();
        }else {
            studentInformation.setStudentRollNumber(generateRollNumber(studentInformation));
            return false;
        }
    }

    private String generateRollNumber(StudentInformation studentInformation){
        StringBuilder rollNumber = new StringBuilder();
        rollNumber.append(LocalDate.now().getYear());
        rollNumber.append(studentInformation.getStudentFirstName().substring(0,1).toUpperCase());
        rollNumber.append(studentInformation.getStudentLastName().substring(0,1).toUpperCase());
        Optional<StudentInformation> existingStudentInformation = studentInformationRepository.findFirstByIsActiveIsTrueOrderByStudentInfoIdDesc();
        if (existingStudentInformation.isPresent()){
            StringBuilder idVal = new StringBuilder();
            Long id = existingStudentInformation.get().getStudentInfoId();
            for (int i =id.toString().length() ; i<4;i++){
                idVal.append(0);
            }
            idVal.append(id);
            rollNumber.append(idVal);
        }else {
            rollNumber.append("0001");
        }
        return rollNumber.toString();
    }

    private void createLoginDetail(StudentInformation studentInformation){
        LoginDetailDto loginDetailDto = new LoginDetailDto();
        loginDetailDto.setUserId(studentInformation.getStudentInfoId());
        loginDetailDto.setLoginUserId(studentInformation.getContactDetail().getPhoneNumber());
        loginDetailDto.setLoginPassword(SSMUtil.convertLocalDateToString(studentInformation.getDob(),
                ApplicationConstants.DATE_STRING_FORMAT));
        loginDetailDto.setRollId(15l);
        loginUserManagerService.putLoginUser(loginDetailDto);
    }
}
