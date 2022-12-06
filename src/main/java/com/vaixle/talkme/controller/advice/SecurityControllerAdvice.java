package com.vaixle.talkme.controller.advice;

import com.vaixle.talkme.exception.security.AdmitadCredentialGetTokenException;
import com.vaixle.talkme.exception.security.AdmitadCredentialRefreshTokenException;
import com.vaixle.talkme.payload.response.AdviceErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class SecurityControllerAdvice {

    @ExceptionHandler(value = AdmitadCredentialGetTokenException.class)
    @ResponseStatus(HttpStatus.GONE)
    public AdviceErrorMessage handleGetTokensException(AdmitadCredentialGetTokenException ex, WebRequest request) {
        return new AdviceErrorMessage(
                HttpStatus.GONE.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(value = AdmitadCredentialRefreshTokenException.class)
    @ResponseStatus(HttpStatus.GONE)
    public AdviceErrorMessage handleUpdateTokensRefreshException(AdmitadCredentialRefreshTokenException ex, WebRequest request) {
        return new AdviceErrorMessage(
                HttpStatus.GONE.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }
}