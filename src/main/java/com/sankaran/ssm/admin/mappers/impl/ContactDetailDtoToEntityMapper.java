package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.ContactDetailDto;
import com.sankaran.ssm.admin.entities.ContactDetail;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactDetailDtoToEntityMapper implements DtoEntityMapper<ContactDetailDto, ContactDetail> {

    /**
     * @param source
     * @return
     */
    @Override
    public ContactDetail convert(ContactDetailDto source) {
        ContactDetail contactDetail = new ContactDetail(source.getContactDetailId(), source.getAddress1(),
                source.getAddress2(), source.getCity(), source.getStateCode(), source.getCountryCode(),
                source.getPhoneNumber(), source.getAltPhoneNumber(), source.getEmailId());
        contactDetail.setCreatedBy(source.getCreatedBy());
        contactDetail.setCreatedDate(LocalDateTime.now());
        contactDetail.setModifiedBy(source.getModifiedBy());
        contactDetail.setModifiedDate(LocalDateTime.now());
        contactDetail.setIsActive(true);
        return contactDetail;
    }

    /**
     * @param sourceList
     * @return
     */
    @Override
    public List<ContactDetail> convert(List<ContactDetailDto> sourceList) {
        return sourceList.stream().map(source -> {
            ContactDetail contactDetail = new ContactDetail(source.getContactDetailId(), source.getAddress1(),
                    source.getAddress2(), source.getCity(), source.getStateCode(), source.getCountryCode(),
                    source.getPhoneNumber(), source.getAltPhoneNumber(), source.getEmailId());
            contactDetail.setCreatedBy(source.getCreatedBy());
            contactDetail.setCreatedDate(LocalDateTime.now());
            contactDetail.setModifiedBy(source.getModifiedBy());
            contactDetail.setModifiedDate(LocalDateTime.now());
            contactDetail.setIsActive(true);
            return contactDetail;
        }).collect(Collectors.toList());
    }
}
