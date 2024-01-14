package com.sankaran.ssm.admin.controllers;

import com.sankaran.ssm.admin.dtos.ApplicationCommonResponseDto;
import com.sankaran.ssm.admin.dtos.StaffInformationDto;
import com.sankaran.ssm.admin.service.StaffInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/staff-information")
public class StaffInformationController {

    @Autowired
    private StaffInformationService staffInformationService;

    @GetMapping("/tutor-detail")
    public ResponseEntity<List<StaffInformationDto>> getTutorDetail(){
        return ResponseEntity.ok().body(staffInformationService.getTutorInformations());
    }

    @GetMapping("/staff-detail")
    public ResponseEntity<List<StaffInformationDto>> getAllStaffDetails(){
        return ResponseEntity.ok().body(staffInformationService.getAllStaffDetails());
    }

    @PutMapping("/save")
    public ResponseEntity<ApplicationCommonResponseDto> saveStaffDetail(@RequestBody StaffInformationDto staffInformationDto){
        return ResponseEntity.ok().body(new ApplicationCommonResponseDto(staffInformationService.saveStaffDetail(staffInformationDto),
                "Success"));
    }
}
