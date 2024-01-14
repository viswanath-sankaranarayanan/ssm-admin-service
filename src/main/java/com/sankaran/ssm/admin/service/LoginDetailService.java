package com.sankaran.ssm.admin.service;

import com.sankaran.ssm.admin.dtos.LoginDetailDto;
import com.sankaran.ssm.admin.exceptionhandler.AuthenticationException;

import java.util.List;

public interface LoginDetailService {

    void putLoginUser(LoginDetailDto loginDetailDto);
    void authenticateUserId(LoginDetailDto loginDetailDto) throws AuthenticationException;
    LoginDetailDto login(LoginDetailDto loginDetailDto) throws AuthenticationException;

    List<LoginDetailDto> getAllLoginUserDetail();

    String getLoggedInUserDetail(Long userId);

}
