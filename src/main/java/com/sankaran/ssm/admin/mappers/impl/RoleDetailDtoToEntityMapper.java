package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.RoleDetailDto;
import com.sankaran.ssm.admin.entities.RoleDetail;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleDetailDtoToEntityMapper implements DtoEntityMapper<RoleDetailDto, RoleDetail> {

    @Override
    public RoleDetail convert(RoleDetailDto source) {
        RoleDetail roleDetail = new RoleDetail(source.getRoleId(), source.getRoleName());
        roleDetail.setIsActive(source.getIsActive());
        roleDetail.setCreatedBy(source.getCreatedBy());
        roleDetail.setCreatedDate(source.getCreatedDate());
        roleDetail.setModifiedBy(source.getModifiedBy());
        roleDetail.setModifiedDate(source.getModifiedDate());
        return roleDetail;
    }

    @Override
    public List<RoleDetail> convert(List<RoleDetailDto> sourceList) {
        return sourceList.stream().map( source -> {
            RoleDetail roleDetail = new RoleDetail(source.getRoleId(), source.getRoleName());
            roleDetail.setIsActive(source.getIsActive());
            roleDetail.setCreatedBy(source.getCreatedBy());
            roleDetail.setCreatedDate(source.getCreatedDate());
            roleDetail.setModifiedBy(source.getModifiedBy());
            roleDetail.setModifiedDate(source.getModifiedDate());
            return roleDetail;
        }).collect(Collectors.toList());
    }
}
