package com.sankaran.ssm.admin.controllers;

import com.sankaran.ssm.admin.dtos.ApplicationCommonResponseDto;
import com.sankaran.ssm.admin.dtos.ApplicationConstants;
import com.sankaran.ssm.admin.dtos.MenuDetailDto;
import com.sankaran.ssm.admin.dtos.MenuRoleMappingDto;
import com.sankaran.ssm.admin.service.MenuRoleMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/menu-role-mapping")
@RestController
public class MenuRoleMappingController {

    @Autowired
    MenuRoleMappingService menuRoleMappingService;

    @PutMapping("/save")
    public ResponseEntity<ApplicationCommonResponseDto> saveMenuRoleMapping(@RequestParam Long roleId,
            @RequestBody List<MenuRoleMappingDto> menuRoleMappingDtos){
        return ResponseEntity.status(HttpStatus.OK).body(new ApplicationCommonResponseDto(
                menuRoleMappingService.saveMenuRoleMapping(roleId, menuRoleMappingDtos), ApplicationConstants.SUCCESS_STATUS
        ));
    }

    @GetMapping("/roleMapping/{roleId}")
    public ResponseEntity<List<MenuRoleMappingDto>> fetchMenuDetailForRollMapping(@PathVariable(value = "roleId")Long roleId){
        return ResponseEntity.status(HttpStatus.OK).body(menuRoleMappingService.getAllRoleBasedMenus(roleId));
    }
}
