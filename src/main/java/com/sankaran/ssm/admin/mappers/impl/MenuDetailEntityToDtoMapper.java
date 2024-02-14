package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.MenuDetailDto;
import com.sankaran.ssm.admin.entities.MenuDetail;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuDetailEntityToDtoMapper implements DtoEntityMapper<MenuDetail, MenuDetailDto> {

    @Override
    public MenuDetailDto convert(MenuDetail source) {
        MenuDetailDto menuDetailDto = new MenuDetailDto(source.getMenuId(), source.getMenuName(), source.getContentName(), false);
        menuDetailDto.setIsActive(source.getIsActive());
        menuDetailDto.setCreatedBy(source.getCreatedBy());
        menuDetailDto.setCreatedDate(source.getCreatedDate());
        menuDetailDto.setModifiedBy(source.getModifiedBy());
        menuDetailDto.setModifiedDate(source.getModifiedDate());
        return menuDetailDto;
    }

    @Override
    public List<MenuDetailDto> convert(List<MenuDetail> sourceList) {
        return sourceList.stream().map(source -> {
            MenuDetailDto menuDetailDto = new MenuDetailDto(source.getMenuId(), source.getMenuName(), source.getContentName(), false);
            menuDetailDto.setIsActive(source.getIsActive());
            menuDetailDto.setCreatedBy(source.getCreatedBy());
            menuDetailDto.setCreatedDate(source.getCreatedDate());
            menuDetailDto.setModifiedBy(source.getModifiedBy());
            menuDetailDto.setModifiedDate(source.getModifiedDate());
            return menuDetailDto;
        }).collect(Collectors.toList());
    }
}
