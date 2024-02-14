package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.RoleDetailDto;
import com.sankaran.ssm.admin.entities.RoleDetail;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleDetailEntityToDtoMapper implements DtoEntityMapper<RoleDetail, RoleDetailDto> {

    @Override
    public RoleDetailDto convert(RoleDetail source) {
        RoleDetailDto roleDetailDto = new RoleDetailDto(source.getRoleId(),source.getRoleName());
        roleDetailDto.setIsActive(source.getIsActive());
        roleDetailDto.setCreatedBy(source.getCreatedBy());
        roleDetailDto.setCreatedDate(source.getCreatedDate());
        roleDetailDto.setModifiedBy(source.getModifiedBy());
        roleDetailDto.setModifiedDate(source.getModifiedDate());
        return roleDetailDto;
    }

    @Override
    public List<RoleDetailDto> convert(List<RoleDetail> sourceList) {
        return sourceList.stream().map( source -> {
            RoleDetailDto roleDetailDto = new RoleDetailDto(source.getRoleId(),source.getRoleName());
            roleDetailDto.setIsActive(source.getIsActive());
            roleDetailDto.setCreatedBy(source.getCreatedBy());
            roleDetailDto.setCreatedDate(source.getCreatedDate());
            roleDetailDto.setModifiedBy(source.getModifiedBy());
            roleDetailDto.setModifiedDate(source.getModifiedDate());
            return roleDetailDto;
        }).collect(Collectors.toList());
    }
}
