package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.MenuDetailDto;
import com.sankaran.ssm.admin.entities.MenuDetail;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuDetailDtoToEntityMapper implements DtoEntityMapper<MenuDetailDto, MenuDetail> {

    @Override
    public MenuDetail convert(MenuDetailDto source) {
        MenuDetail menuDetail = new MenuDetail(source.getMenuId(), source.getMenuName(), source.getContentName());
        menuDetail.setIsActive(source.getIsActive());
        menuDetail.setCreatedBy(source.getCreatedBy());
        menuDetail.setCreatedDate(source.getCreatedDate());
        menuDetail.setModifiedBy(source.getModifiedBy());
        menuDetail.setModifiedDate(source.getModifiedDate());
        return menuDetail;
    }

    @Override
    public List<MenuDetail> convert(List<MenuDetailDto> sourceList) {
        return sourceList.stream().map(source -> {
            MenuDetail menuDetail = new MenuDetail(source.getMenuId(), source.getMenuName(), source.getContentName());
            menuDetail.setIsActive(source.getIsActive());
            menuDetail.setCreatedBy(source.getCreatedBy());
            menuDetail.setCreatedDate(source.getCreatedDate());
            menuDetail.setModifiedBy(source.getModifiedBy());
            menuDetail.setModifiedDate(source.getModifiedDate());
            return menuDetail;
        }).collect(Collectors.toList());
    }
}
