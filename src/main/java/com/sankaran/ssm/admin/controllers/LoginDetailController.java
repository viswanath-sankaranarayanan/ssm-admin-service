package com.sankaran.ssm.admin.controllers;

import com.sankaran.ssm.admin.dtos.ApplicationCommonResponseDto;
import com.sankaran.ssm.admin.dtos.LoginDetailDto;
import com.sankaran.ssm.admin.exceptionhandler.AuthenticationException;
import com.sankaran.ssm.admin.service.LoginDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/login")
@RestController
public class LoginDetailController {

    @Autowired
    LoginDetailService loginDetailService;

    @PutMapping("/loginUser")
    public ResponseEntity<ApplicationCommonResponseDto> putLoginUser(@RequestBody LoginDetailDto loginDetailDto){
        loginDetailService.putLoginUser(loginDetailDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApplicationCommonResponseDto("User Created Successfully","Success"));
    }

    @PostMapping("/authenticate/loginId")
    public ResponseEntity<ApplicationCommonResponseDto> authenticateLoginUser(@RequestBody LoginDetailDto loginDetailDto) throws AuthenticationException {
        loginDetailService.authenticateUserId(loginDetailDto);
        return new ResponseEntity<ApplicationCommonResponseDto>(
                new ApplicationCommonResponseDto("UserId Authentication Success","Success"), HttpStatus.OK);
    }

    @PostMapping("/authenticate/login")
    public ResponseEntity<LoginDetailDto> login(@RequestBody LoginDetailDto loginDetailDto) throws AuthenticationException {
        return new ResponseEntity<LoginDetailDto>(
                loginDetailService.login(loginDetailDto), HttpStatus.OK);
    }

    @GetMapping("user-detail")
    public ResponseEntity<List<LoginDetailDto>> getAllLoginUserDetail(){
        return new ResponseEntity<List<LoginDetailDto>>(
                loginDetailService.getAllLoginUserDetail(), HttpStatus.OK );
    }

    @GetMapping("user-detail/{userId}")
    public ResponseEntity<String> getLoggedInUserDetail(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(loginDetailService.getLoggedInUserDetail(userId), HttpStatus.OK);
    }
}
