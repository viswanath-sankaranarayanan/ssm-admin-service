package com.sankaran.ssm.admin.service;

import com.sankaran.ssm.admin.dtos.RoleDetailDto;

import java.util.List;

public interface RoleDetailService {

    List<RoleDetailDto> getAllRoleDetails();

    List<RoleDetailDto> filterRoleDetails(String filterValue);

    String saveRoleDetails(RoleDetailDto roleDetailDto);

}
