package com.sankaran.ssm.admin.service;

import com.sankaran.ssm.admin.dtos.MenuDetailDto;

import java.util.List;

public interface MenuDetailService {

    List<MenuDetailDto> getAllMenuDetails();

    List<MenuDetailDto> getMenuDetailForRoll(Long rollId);

    List<MenuDetailDto> filterMenuDetail(String filterValue);

    String saveMenudetail(MenuDetailDto menuDetailDto);
}
