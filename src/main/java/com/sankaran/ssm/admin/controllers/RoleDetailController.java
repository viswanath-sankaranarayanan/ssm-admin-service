package com.sankaran.ssm.admin.controllers;

import com.sankaran.ssm.admin.dtos.ApplicationCommonResponseDto;
import com.sankaran.ssm.admin.dtos.ApplicationConstants;
import com.sankaran.ssm.admin.dtos.RoleDetailDto;
import com.sankaran.ssm.admin.service.RoleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/role-detail")
public class RoleDetailController {

    @Autowired
    RoleDetailService roleDetailService;

    @GetMapping("/all")
    public ResponseEntity<List<RoleDetailDto>> getAllRoleDetail(){
        return ResponseEntity.status(HttpStatus.OK).body(roleDetailService.getAllRoleDetails());
    }

    @GetMapping("/filter/{filterValue}")
    public ResponseEntity<List<RoleDetailDto>> filterRoleDetail(@PathVariable(value = "filterValue") String filterValue){
        return ResponseEntity.status(HttpStatus.OK).body(roleDetailService.filterRoleDetails(filterValue));
    }

    @PutMapping("/save")
    public ResponseEntity<ApplicationCommonResponseDto> saveRoleDetail(@RequestBody RoleDetailDto roleDetailDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ApplicationCommonResponseDto(
                roleDetailService.saveRoleDetails(roleDetailDto), ApplicationConstants.SUCCESS_STATUS
        ));
    }
}
