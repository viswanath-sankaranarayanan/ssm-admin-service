package com.sankaran.ssm.admin.controllers;

import com.sankaran.ssm.admin.dtos.ApplicationCommonResponseDto;
import com.sankaran.ssm.admin.dtos.StudentInformationDto;
import com.sankaran.ssm.admin.service.StudentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/student-details")
@RestController
public class StudentDetailsController {

    @Autowired
    private StudentInformationService studentInformationService;

    @GetMapping("/find")
    public ResponseEntity<List<StudentInformationDto>> getStudentDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(studentInformationService.getStudentDetails());
    }

    @GetMapping("/filter/{filterValue}")
    public ResponseEntity<List<StudentInformationDto>> getStudentDetails(@PathVariable String filterValue){
        return ResponseEntity.status(HttpStatus.OK).body(studentInformationService.filterStudentDetails(filterValue));
    }

    @PutMapping("/save")
    public ResponseEntity<ApplicationCommonResponseDto> saveStudentDetail(@RequestBody StudentInformationDto studentInformationDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ApplicationCommonResponseDto(studentInformationService.saveStudentInformation(studentInformationDto),"Success"));
    }

}
