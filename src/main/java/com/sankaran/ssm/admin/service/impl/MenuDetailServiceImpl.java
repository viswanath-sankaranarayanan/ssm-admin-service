package com.sankaran.ssm.admin.service.impl;

import com.sankaran.ssm.admin.dtos.ApplicationConstants;
import com.sankaran.ssm.admin.dtos.MenuDetailDto;
import com.sankaran.ssm.admin.entities.MenuDetail;
import com.sankaran.ssm.admin.mappers.impl.MenuDetailDtoToEntityMapper;
import com.sankaran.ssm.admin.mappers.impl.MenuDetailEntityToDtoMapper;
import com.sankaran.ssm.admin.repository.MenuDetailRepository;
import com.sankaran.ssm.admin.service.MenuDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MenuDetailServiceImpl implements MenuDetailService {

    @Autowired
    MenuDetailRepository menuDetailRepository;

    @Autowired
    MenuDetailEntityToDtoMapper menuDetailEntityToDtoMapper;

    @Autowired
    MenuDetailDtoToEntityMapper menuDetailDtoToEntityMapper;

    @Override
    public List<MenuDetailDto> getAllMenuDetails() {
        List<MenuDetail> menuDetails = menuDetailRepository.findAllByIsActiveIsTrue();
        return menuDetailEntityToDtoMapper.convert(menuDetails);
    }

    @Override
    public List<MenuDetailDto> getMenuDetailForRoll(Long rollId) {
        List<MenuDetail> menuDetails = menuDetailRepository.findByRoleId(rollId);
        return menuDetailEntityToDtoMapper.convert(menuDetails);
    }

    @Override
    public List<MenuDetailDto> filterMenuDetail(String filterValue) {
        List<MenuDetail> menuDetails = menuDetailRepository.filterMenuDetail(filterValue);
        return menuDetailEntityToDtoMapper.convert(menuDetails);
    }

    @Override
    public String saveMenudetail(MenuDetailDto menuDetailDto) {
        MenuDetail menuDetail = menuDetailDtoToEntityMapper.convert(menuDetailDto);
        if (!Objects.isNull(menuDetail.getMenuId())){
            Optional<MenuDetail> existingMenuDetail = menuDetailRepository.findById(menuDetail.getMenuId());
            if (existingMenuDetail.isPresent()){
                existingMenuDetail.get().setIsActive(false);
                existingMenuDetail.get().setMenuId(null);
                menuDetailRepository.saveAndFlush(existingMenuDetail.get());
            }
            menuDetail.setCreatedBy(existingMenuDetail.get().getCreatedBy());
            menuDetail.setCreatedDate(existingMenuDetail.get().getCreatedDate());
        }else {
            menuDetail.setCreatedDate(LocalDateTime.now());
        }
        menuDetail.setModifiedDate(LocalDateTime.now());
        menuDetail.setIsActive(true);
        menuDetailRepository.saveAndFlush(menuDetail);
        return ApplicationConstants.MENU_DETAIL_SAVE_SUCCESS_MSG;
    }

    private void checkMappedMenusForRole(List<MenuDetailDto> allMenuDetailDtos, List<MenuDetailDto> menuDetailDtos){
        allMenuDetailDtos.stream().forEach(menuDetailDto -> {
            if (menuDetailDtos.contains(menuDetailDto)){
                menuDetailDto.setMenuSelected(true);
            }else {
                menuDetailDto.setMenuSelected(false);
            }
        });
    }
}
