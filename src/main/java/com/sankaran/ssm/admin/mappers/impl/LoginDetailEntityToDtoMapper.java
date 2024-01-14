package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.LoginDetailDto;
import com.sankaran.ssm.admin.entities.LoginDetail;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoginDetailEntityToDtoMapper implements DtoEntityMapper<LoginDetail, LoginDetailDto> {
    @Override
    public LoginDetailDto convert(LoginDetail source) {
        LoginDetailDto loginDetailDto = new LoginDetailDto(source.getLoginDetailId(), source.getLoginUserId(), source.getUserId(),
                source.getLoginPassword(), source.getRollId(), null);
        loginDetailDto.setIsActive(source.getIsActive());
        loginDetailDto.setCreatedBy(source.getCreatedBy());
        loginDetailDto.setCreatedDate(source.getCreatedDate());
        loginDetailDto.setModifiedBy(source.getModifiedBy());
        loginDetailDto.setModifiedDate(source.getModifiedDate());
        return loginDetailDto;
    }

    @Override
    public List<LoginDetailDto> convert(List<LoginDetail> sourceList) {
        return sourceList.stream().map(source -> {
            LoginDetailDto loginDetailDto = new LoginDetailDto(source.getLoginDetailId(), source.getLoginUserId(), source.getUserId(),
                    source.getLoginPassword(), source.getRollId(), null);
            loginDetailDto.setIsActive(source.getIsActive());
            loginDetailDto.setCreatedBy(source.getCreatedBy());
            loginDetailDto.setCreatedDate(source.getCreatedDate());
            loginDetailDto.setModifiedBy(source.getModifiedBy());
            loginDetailDto.setModifiedDate(source.getModifiedDate());
            return loginDetailDto;
        }).collect(Collectors.toList());
    }
}
