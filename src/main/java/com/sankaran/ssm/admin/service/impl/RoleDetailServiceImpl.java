package com.sankaran.ssm.admin.service.impl;

import com.sankaran.ssm.admin.dtos.ApplicationConstants;
import com.sankaran.ssm.admin.dtos.RoleDetailDto;
import com.sankaran.ssm.admin.entities.RoleDetail;
import com.sankaran.ssm.admin.mappers.impl.RoleDetailDtoToEntityMapper;
import com.sankaran.ssm.admin.mappers.impl.RoleDetailEntityToDtoMapper;
import com.sankaran.ssm.admin.repository.RoleDetailRepository;
import com.sankaran.ssm.admin.service.RoleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoleDetailServiceImpl implements RoleDetailService {

    @Autowired
    RoleDetailRepository roleDetailRepository;

    @Autowired
    RoleDetailEntityToDtoMapper roleDetailEntityToDtoMapper;

    @Autowired
    RoleDetailDtoToEntityMapper roleDetailDtoToEntityMapper;

    @Override
    public List<RoleDetailDto> getAllRoleDetails() {
        List<RoleDetail> roleDetails = roleDetailRepository.findByIsActiveIsTrue();
        return roleDetailEntityToDtoMapper.convert(roleDetails);
    }

    @Override
    public List<RoleDetailDto> filterRoleDetails(String filterValue) {
        List<RoleDetail> roleDetails = roleDetailRepository.filterRoleDetail(filterValue.toUpperCase());
        return roleDetailEntityToDtoMapper.convert(roleDetails);
    }

    @Override
    public String saveRoleDetails(RoleDetailDto roleDetailDto) {
        RoleDetail roleDetail = roleDetailDtoToEntityMapper.convert(roleDetailDto);
        if (!Objects.isNull(roleDetail.getRoleId())){
            Optional<RoleDetail> existingRoleDetail = roleDetailRepository.findById(roleDetail.getRoleId());
            if (existingRoleDetail.isPresent()){
                existingRoleDetail.get().setIsActive(false);
                existingRoleDetail.get().setRoleId(null);
                roleDetailRepository.saveAndFlush(existingRoleDetail.get());
                roleDetail.setCreatedDate(existingRoleDetail.get().getCreatedDate());
            }
        }else {
            roleDetail.setCreatedDate(LocalDateTime.now());
        }
        roleDetail.setIsActive(true);
        roleDetail.setModifiedDate(LocalDateTime.now());
        roleDetailRepository.saveAndFlush(roleDetail);
        return ApplicationConstants.ROLE_DETAIL_SAVE_SUCCESS_MSG;
    }
}
