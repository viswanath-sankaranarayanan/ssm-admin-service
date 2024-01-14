package com.sankaran.ssm.admin.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sankaran.ssm.admin.entities.PersonalInformation;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentInformationDto extends SuperDto{
    private Long studentInfoId;
    private String studentRollNumber;
    private String studentFirstName;
    private String studentMiddleName;
    private String studentLastName;
    private String gender;
    private String bloodGroup;
    private LocalDate dob;
    private PersonalInformationDto personalInformation;
    private ContactDetailDto contactDetail;
}
