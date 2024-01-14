package com.sankaran.ssm.admin.controllers;

import com.sankaran.ssm.admin.dtos.HolidayDto;
import com.sankaran.ssm.admin.service.HolidayService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/admin/master")
public class MasterDateController {

    @Autowired
    HolidayService holidayService;

    @GetMapping("/holiday-list")
    public ResponseEntity<List<HolidayDto>> getCurrentYearHolidayList(){
        return ResponseEntity.ok().body(holidayService.getCurrentYearHolidayList());
    }

}
