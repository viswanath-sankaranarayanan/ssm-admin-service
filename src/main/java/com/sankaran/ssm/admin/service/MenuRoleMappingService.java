package com.sankaran.ssm.admin.service;

import com.sankaran.ssm.admin.dtos.MenuRoleMappingDto;

import java.util.List;

public interface MenuRoleMappingService {

    List<MenuRoleMappingDto> getAllRoleBasedMenus(Long roleId);
    String saveMenuRoleMapping(Long roleId, List<MenuRoleMappingDto> menuRoleMappingDtos);
}
