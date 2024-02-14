package com.sankaran.ssm.admin.service.impl;

import com.sankaran.ssm.admin.dtos.ApplicationConstants;
import com.sankaran.ssm.admin.dtos.MenuDetailDto;
import com.sankaran.ssm.admin.dtos.MenuRoleMappingDto;
import com.sankaran.ssm.admin.entities.MenuDetail;
import com.sankaran.ssm.admin.entities.MenuRoleMapping;
import com.sankaran.ssm.admin.repository.MenuDetailRepository;
import com.sankaran.ssm.admin.repository.MenuRoleMappingRepository;
import com.sankaran.ssm.admin.service.MenuRoleMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MenuRoleMappingServiceImpl implements MenuRoleMappingService {

    @Autowired
    MenuRoleMappingRepository menuRoleMappingRepository;

    @Autowired
    MenuDetailRepository menuDetailRepository;

    @Override
    public List<MenuRoleMappingDto> getAllRoleBasedMenus(Long roleId){
        List<MenuDetail> allMenuDetails = menuDetailRepository.findAllByIsActiveIsTrue();
        List<MenuRoleMapping> menuRoleMappingList = menuRoleMappingRepository.findByRoleIdAndIsActiveIsTrue(roleId);
        return checkMappedMenusForRole(allMenuDetails, menuRoleMappingList);
    }

    @Override
    public String saveMenuRoleMapping(Long roleId, List<MenuRoleMappingDto> menuRoleMappingDtos) {
        List<MenuRoleMapping> menuRoleMappingList = new ArrayList<>();
        menuRoleMappingDtos.stream().forEach(obj -> {
            MenuRoleMapping menuRoleMapping = menuRoleMappingRepository.findByRoleIdAndMenuId(roleId, obj.getMenuDetail().getMenuId());
            if (!Objects.isNull(menuRoleMapping)){
                menuRoleMapping.setIsActive(obj.getMenuDetail().getMenuSelected());
                menuRoleMapping.setModifiedBy(obj.getModifiedBy());
                menuRoleMapping.setModifiedDate(LocalDateTime.now());
                menuRoleMappingList.add(menuRoleMapping);
            }else {
                menuRoleMapping = new MenuRoleMapping();
                menuRoleMapping.setRoleId(roleId);
                menuRoleMapping.setMenuId(obj.getMenuDetail().getMenuId());
                menuRoleMapping.setIsActive(true);
                menuRoleMapping.setCreatedBy(obj.getCreatedBy());
                menuRoleMapping.setCreatedDate(LocalDateTime.now());
                menuRoleMapping.setModifiedBy(obj.getModifiedBy());
                menuRoleMapping.setModifiedDate(LocalDateTime.now());
                menuRoleMappingList.add(menuRoleMapping);

            }
        });
        menuRoleMappingRepository.saveAllAndFlush(menuRoleMappingList);
        return ApplicationConstants.MENU_ROLE_MAPPING_SUCCESS_MSG;
    }

    private List<MenuRoleMappingDto> checkMappedMenusForRole(List<MenuDetail> allMenuDetailDtos, List<MenuRoleMapping> menuRoleMappingList){
        List<MenuRoleMappingDto> menuRoleMappingDtos = new ArrayList<>();
        List<Long> mappedMenuIds = menuRoleMappingList.stream().map(obj -> obj.getMenuId()).collect(Collectors.toList());
        allMenuDetailDtos.stream().forEach(obj -> {
            MenuRoleMappingDto menuRoleMappingDto = new MenuRoleMappingDto();
            MenuDetailDto menuDetailDto = new MenuDetailDto(obj.getMenuId(), obj.getMenuName(), obj.getContentName(),mappedMenuIds.contains(obj.getMenuId()));
            menuRoleMappingDto.setMenuDetail(menuDetailDto);
            menuRoleMappingDtos.add(menuRoleMappingDto);
        });
        return menuRoleMappingDtos;
    }
}
