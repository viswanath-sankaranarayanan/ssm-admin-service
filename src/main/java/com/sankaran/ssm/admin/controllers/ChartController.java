package com.sankaran.ssm.admin.controllers;

import com.sankaran.ssm.admin.dtos.ChartDto;
import com.sankaran.ssm.admin.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/chart")
public class ChartController {

    @Autowired
    ChartService chartService;

    @GetMapping("/student-attendance")
    public ResponseEntity<List<ChartDto>> getStudentAttendanceChart(){
        return ResponseEntity.status(HttpStatus.OK).body(chartService.getStudentChart());
    }

    @GetMapping("/staff-count")
    public ResponseEntity<List<ChartDto>> getStaffCountChart(){
        return ResponseEntity.status(HttpStatus.OK).body(chartService.getStaffCountChart());
    }
}
