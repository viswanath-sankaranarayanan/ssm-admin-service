package com.sankaran.ssm.admin.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHander extends ResponseEntityExceptionHandler {

    private ResponseEntity<ApplicationErrorResponse> buildErrorResponse(HttpStatus httpStatus, String message){
        ApplicationErrorResponse applicationErrorResponse = new ApplicationErrorResponse(httpStatus.value(), message);
        return ResponseEntity.status(httpStatus).body(applicationErrorResponse);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ApplicationErrorResponse> userAuthenticationException(Exception exception, WebRequest webRequest){
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, exception.getMessage());
    }
}
