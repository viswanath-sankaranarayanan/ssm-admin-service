package com.sankaran.ssm.admin.service.impl;

import com.sankaran.ssm.admin.dtos.LoginDetailDto;
import com.sankaran.ssm.admin.entities.LoginDetail;
import com.sankaran.ssm.admin.exceptionhandler.AuthenticationException;
import com.sankaran.ssm.admin.mappers.impl.LoginDetailDtoToEntityMapper;
import com.sankaran.ssm.admin.mappers.impl.LoginDetailEntityToDtoMapper;
import com.sankaran.ssm.admin.repository.LoginDetailRepository;
import com.sankaran.ssm.admin.service.LoginDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LoginDetailServiceImpl implements LoginDetailService {

    @Autowired
    LoginDetailRepository loginDetailRepository;

    @Autowired
    LoginDetailDtoToEntityMapper loginDetailDtoToEntityMapper;

    @Autowired
    LoginDetailEntityToDtoMapper loginUserManagerEntityToDtoMapper;

    @Override
    public void putLoginUser(LoginDetailDto loginDetailDto) {
        LoginDetail loginDetail = loginDetailDtoToEntityMapper.convert(loginDetailDto);
        loginDetailRepository.save(loginDetail);
    }

    @Override
    public void authenticateUserId(LoginDetailDto loginDetailDto) throws AuthenticationException {
        Optional<LoginDetail> loginDetail = loginDetailRepository.findByLoginUserIdAndIsActiveIsTrue(loginDetailDto.getLoginUserId());
        if (!loginDetail.isPresent())
            throw new AuthenticationException("Not a valid user to login");
    }

    @Override
    public LoginDetailDto login(LoginDetailDto loginDetailDto) throws AuthenticationException {
        Optional<LoginDetail> loginDetail = loginDetailRepository.findByLoginUserIdAndLoginPasswordAndIsActiveIsTrue(
                loginDetailDto.getLoginUserId(), loginDetailDto.getLoginPassword());

        if (!loginDetail.isPresent()){
            throw new AuthenticationException("Not a valid User Name or Password");
        } else {
            return loginUserManagerEntityToDtoMapper.convert(loginDetail.get());
        }

    }

    /**
     * @return
     */
    @Override
    public List<LoginDetailDto> getAllLoginUserDetail() {
        List<LoginDetail> loginDetails = loginDetailRepository.findAllByIsActiveIsTrue();
        return loginUserManagerEntityToDtoMapper.convert(loginDetails);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public String getLoggedInUserDetail(Long userId) {
        return loginDetailRepository.getLoggedInUserName(userId);
    }
}
