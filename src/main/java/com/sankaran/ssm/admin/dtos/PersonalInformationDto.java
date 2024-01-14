package com.sankaran.ssm.admin.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalInformationDto extends SuperDto{
    private Long personalInfoId;
    private Long personTypeId;
    private String fatherFirstName;
    private String fatherMiddleName;
    private String fatherLastName;
    private String fatherFullName;
    private String motherFirstName;
    private String motherMiddleName;
    private String motherLastName;
    private String motherFullName;
    private String gardianFirstName;
    private String gardianMiddleName;
    private String gardianLastName;
    private String gardianFullName;
    private String gardianType;
}
