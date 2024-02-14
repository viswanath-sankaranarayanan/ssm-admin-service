package com.sankaran.ssm.admin.controllers;

import com.sankaran.ssm.admin.dtos.ApplicationCommonResponseDto;
import com.sankaran.ssm.admin.dtos.ApplicationConstants;
import com.sankaran.ssm.admin.dtos.MenuDetailDto;
import com.sankaran.ssm.admin.dtos.MenuRoleMappingDto;
import com.sankaran.ssm.admin.service.MenuDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/menu-detail")
@RestController
public class MenuDetailController {

    @Autowired
    MenuDetailService menuDetailService;

    @GetMapping("/all")
    public ResponseEntity<List<MenuDetailDto>> fetchAllMenuDetail(){
        return ResponseEntity.status(HttpStatus.OK).body(menuDetailService.getAllMenuDetails());
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<MenuDetailDto>> fetchMenuDetailForRoll(@PathVariable(value = "roleId")Long roleId){
        return ResponseEntity.status(HttpStatus.OK).body(menuDetailService.getMenuDetailForRoll(roleId));
    }

    @GetMapping("/filter/{filterValue}")
    public ResponseEntity<List<MenuDetailDto>> filterMenuDetail(@PathVariable(value = "filterValue")String filterValue){
        return ResponseEntity.status(HttpStatus.OK).body(menuDetailService.filterMenuDetail(filterValue));
    }

    @PutMapping("/save")
    public ResponseEntity<ApplicationCommonResponseDto> saveMenuDetail(@RequestBody MenuDetailDto menuDetailDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ApplicationCommonResponseDto(
                menuDetailService.saveMenudetail(menuDetailDto), ApplicationConstants.SUCCESS_STATUS
        ));
    }
}
