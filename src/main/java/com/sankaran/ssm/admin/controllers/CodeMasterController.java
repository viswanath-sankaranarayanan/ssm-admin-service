package com.sankaran.ssm.admin.controllers;

import com.sankaran.ssm.admin.dtos.ApplicationCommonResponseDto;
import com.sankaran.ssm.admin.dtos.CodeMasterDto;
import com.sankaran.ssm.admin.service.CodeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/code-master")
@RestController
public class CodeMasterController {

    @Autowired
    CodeMasterService codeMasterService;

    @PutMapping("code-master-details")
    public ResponseEntity<ApplicationCommonResponseDto> putCodeMasters(@RequestBody List<CodeMasterDto> codeMasterDtos){
        codeMasterService.putCodeValue(codeMasterDtos);
        return ResponseEntity.status(HttpStatus.OK).body(new ApplicationCommonResponseDto("Successfully Added","Success"));
    }

    @PutMapping("code-master-detail")
    public ResponseEntity<ApplicationCommonResponseDto> putCodeMaster(@RequestBody CodeMasterDto codeMasterDtos){
        codeMasterService.putCodeValue(codeMasterDtos);
        return ResponseEntity.status(HttpStatus.OK).body(new ApplicationCommonResponseDto("Successfully Added","Success"));
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getCodeMasterTypeList(){
        return ResponseEntity.status(HttpStatus.OK).body(codeMasterService.getCodeValueTypes());
    }

    @PostMapping("/code-values")
    public ResponseEntity<List<CodeMasterDto>> getCodeMasterList(@RequestBody CodeMasterDto codeMasterDto){
        return ResponseEntity.status(HttpStatus.OK).body(codeMasterService.getCodeMasterDetails(codeMasterDto));
    }

    @GetMapping("/filter/{filterValue}")
    public ResponseEntity<List<CodeMasterDto>> filterCodeMaster(@PathVariable String filterValue){
        return ResponseEntity.status(HttpStatus.OK).body(codeMasterService.filterCodeMasterDetails(filterValue));
    }
}
