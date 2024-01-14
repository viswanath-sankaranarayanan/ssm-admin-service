package com.sankaran.ssm.admin.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sankaran.ssm.admin.entities.PersonalInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaffInformationDto extends SuperDto{

    private Long staffInfoId;
    private String staffId;
    private String staffFirstName;
    private String staffMiddleName;
    private String staffLastName;
    private String staffFullName;
    private String staffPhoneNumber;
    private String staffEmailId;
    private LocalDate dob;
    private String gender;
    private String bloodGroup;
    private Long staffType;
    private CodeMasterDto staffTypeCode;
    private PersonalInformationDto personalInformation;
    private ContactDetailDto contactDetail;
}
