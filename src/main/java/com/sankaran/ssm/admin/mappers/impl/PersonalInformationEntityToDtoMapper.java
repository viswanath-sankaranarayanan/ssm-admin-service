package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.PersonalInformationDto;
import com.sankaran.ssm.admin.entities.PersonalInformation;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonalInformationEntityToDtoMapper implements DtoEntityMapper<PersonalInformation, PersonalInformationDto> {
    /**
     * @param source
     * @return
     */
    @Override
    public PersonalInformationDto convert(PersonalInformation source) {
        String fatherFullName = String.join(" ", Optional.ofNullable(source.getFatherFirstName()).orElse(""),
                Optional.ofNullable(source.getFatherMiddleName()).orElse(""),
                Optional.ofNullable(source.getFatherLastName()).orElse(""));
        String motherFullName = String.join(" ", Optional.ofNullable(source.getMotherFirstName()).orElse(""),
                Optional.ofNullable(source.getMotherMiddleName()).orElse(""),
                Optional.ofNullable(source.getMotherLastName()).orElse(""));
        String gardianFullName = String.join(" ", Optional.ofNullable(source.getGardianFirstName()).orElse(""),
                Optional.ofNullable(source.getGardianMiddleName()).orElse(""),
                Optional.ofNullable(source.getGardianLastName()).orElse(""));
        return new PersonalInformationDto(source.getPersonalInfoId(), source.getPersonTypeId(), source.getFatherFirstName(),
                source.getFatherMiddleName(), source.getFatherLastName(), StringUtils.normalizeSpace(fatherFullName),
                source.getMotherFirstName(), source.getMotherMiddleName(), source.getMotherLastName(), StringUtils.normalizeSpace(motherFullName),
                source.getGardianFirstName(), source.getGardianMiddleName(), source.getGardianLastName(), StringUtils.normalizeSpace(gardianFullName),
                source.getGardianType());
    }

    /**
     * @param sourceList
     * @return
     */
    @Override
    public List<PersonalInformationDto> convert(List<PersonalInformation> sourceList) {
        return sourceList.stream().map(source -> {
            String fatherFullName = String.join(" ", Optional.ofNullable(source.getFatherFirstName()).orElse(""),
                    Optional.ofNullable(source.getFatherMiddleName()).orElse(""),
                    Optional.ofNullable(source.getFatherLastName()).orElse(""));
            String motherFullName = String.join(" ", Optional.ofNullable(source.getMotherFirstName()).orElse(""),
                    Optional.ofNullable(source.getMotherMiddleName()).orElse(""),
                    Optional.ofNullable(source.getMotherLastName()).orElse(""));
            String gardianFullName = String.join(" ", Optional.ofNullable(source.getGardianFirstName()).orElse(""),
                    Optional.ofNullable(source.getGardianMiddleName()).orElse(""),
                    Optional.ofNullable(source.getGardianLastName()).orElse(""));
            return new PersonalInformationDto(source.getPersonalInfoId(), source.getPersonTypeId(), source.getFatherFirstName(),
                    source.getFatherMiddleName(), source.getFatherLastName(), StringUtils.normalizeSpace(fatherFullName),
                    source.getMotherFirstName(), source.getMotherMiddleName(), source.getMotherLastName(), StringUtils.normalizeSpace(motherFullName),
                    source.getGardianFirstName(), source.getGardianMiddleName(), source.getGardianLastName(), StringUtils.normalizeSpace(gardianFullName),
                    source.getGardianType());
        }).collect(Collectors.toList());
    }
}
