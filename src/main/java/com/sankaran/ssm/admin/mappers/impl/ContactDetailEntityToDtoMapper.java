package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.ContactDetailDto;
import com.sankaran.ssm.admin.entities.ContactDetail;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactDetailEntityToDtoMapper implements DtoEntityMapper<ContactDetail, ContactDetailDto> {

    /**
     * @param source
     * @return
     */
    @Override
    public ContactDetailDto convert(ContactDetail source) {
        ContactDetailDto contactDetailDto = new ContactDetailDto(source.getContactDetailId(), source.getAddress1(),
                source.getAddress2(), source.getCity(), source.getStateCode(), source.getCountryCode(),
                source.getPhoneNumber(), source.getAltPhoneNumber(), source.getEmailId());
        contactDetailDto.setCreatedBy(source.getCreatedBy());
        contactDetailDto.setCreatedDate(source.getCreatedDate());
        contactDetailDto.setModifiedBy(source.getModifiedBy());
        contactDetailDto.setModifiedDate(source.getModifiedDate());
        contactDetailDto.setIsActive(source.getIsActive());
        return contactDetailDto;
    }

    /**
     * @param sourceList
     * @return
     */
    @Override
    public List<ContactDetailDto> convert(List<ContactDetail> sourceList) {
        return sourceList.stream().map(source -> {
            ContactDetailDto contactDetailDto = new ContactDetailDto(source.getContactDetailId(), source.getAddress1(),
                    source.getAddress2(), source.getCity(), source.getStateCode(), source.getCountryCode(),
                    source.getPhoneNumber(), source.getAltPhoneNumber(), source.getEmailId());
            contactDetailDto.setCreatedBy(source.getCreatedBy());
            contactDetailDto.setCreatedDate(source.getCreatedDate());
            contactDetailDto.setModifiedBy(source.getModifiedBy());
            contactDetailDto.setModifiedDate(source.getModifiedDate());
            contactDetailDto.setIsActive(source.getIsActive());
            return contactDetailDto;
        }).collect(Collectors.toList());
    }
}
