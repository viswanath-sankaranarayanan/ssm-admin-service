package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.LoginDetailDto;
import com.sankaran.ssm.admin.entities.LoginDetail;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoginDetailDtoToEntityMapper implements DtoEntityMapper<LoginDetailDto, LoginDetail> {

    @Override
    public LoginDetail convert(LoginDetailDto source) {
        LoginDetail loginDetail = new LoginDetail(source.getLoginDetailId(), source.getLoginUserId(),
                source.getUserId(), source.getLoginPassword(), source.getRollId(), null, null);
        loginDetail.setIsActive(source.getIsActive());
        loginDetail.setCreatedBy(source.getCreatedBy());
        loginDetail.setCreatedDate(source.getCreatedDate());
        loginDetail.setModifiedBy(source.getModifiedBy());
        loginDetail.setModifiedDate(source.getModifiedDate());
        return loginDetail;
    }

    @Override
    public List<LoginDetail> convert(List<LoginDetailDto> sourceList) {
        return sourceList.stream().map(source -> {
            LoginDetail loginDetail = new LoginDetail(source.getLoginDetailId(), source.getLoginUserId(),
                    source.getUserId(), source.getLoginPassword(), source.getRollId(), null, null);
            loginDetail.setIsActive(source.getIsActive());
            loginDetail.setCreatedBy(source.getCreatedBy());
            loginDetail.setCreatedDate(source.getCreatedDate());
            loginDetail.setModifiedBy(source.getModifiedBy());
            loginDetail.setModifiedDate(source.getModifiedDate());
            return loginDetail;
        }).collect(Collectors.toList());
    }
}
