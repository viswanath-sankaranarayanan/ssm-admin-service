package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.PersonalInformationDto;
import com.sankaran.ssm.admin.entities.PersonalInformation;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonalInformationDtoToEntityMapper implements DtoEntityMapper<PersonalInformationDto, PersonalInformation> {
    /**
     * @param source
     * @return
     */
    @Override
    public PersonalInformation convert(PersonalInformationDto source) {
        PersonalInformation personalInformation = new PersonalInformation(source.getPersonalInfoId(), source.getPersonTypeId(), source.getFatherFirstName(),
                source.getFatherMiddleName(), source.getFatherLastName(), source.getMotherFirstName(), source.getMotherMiddleName(),
                source.getMotherLastName(), source.getGardianFirstName(), source.getGardianMiddleName(), source.getGardianLastName(),
                source.getGardianType());
        personalInformation.setCreatedBy(source.getCreatedBy());
        personalInformation.setCreatedDate(LocalDateTime.now());
        personalInformation.setModifiedBy(source.getModifiedBy());
        personalInformation.setModifiedDate(LocalDateTime.now());
        personalInformation.setIsActive(true);
        return personalInformation;
    }

    /**
     * @param sourceList
     * @return
     */
    @Override
    public List<PersonalInformation> convert(List<PersonalInformationDto> sourceList) {
        return sourceList.stream().map(source -> {
            PersonalInformation personalInformation = new PersonalInformation(source.getPersonalInfoId(), source.getPersonTypeId(), source.getFatherFirstName(),
                    source.getFatherMiddleName(), source.getFatherLastName(), source.getMotherFirstName(), source.getMotherMiddleName(),
                    source.getMotherLastName(), source.getGardianFirstName(), source.getGardianMiddleName(), source.getGardianLastName(),
                    source.getGardianType());
            personalInformation.setCreatedBy(source.getCreatedBy());
            personalInformation.setCreatedDate(LocalDateTime.now());
            personalInformation.setModifiedBy(source.getModifiedBy());
            personalInformation.setModifiedDate(LocalDateTime.now());
            personalInformation.setIsActive(true);
            return personalInformation;
        }).collect(Collectors.toList());
    }
}
