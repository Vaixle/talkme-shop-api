package com.vaixle.talkme.controller.advice;

import com.vaixle.talkme.exception.shop.ShopNotFoundException;
import com.vaixle.talkme.payload.response.AdviceErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(value = ShopNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AdviceErrorMessage handleHibernateSearchInitializationException(ShopNotFoundException ex, WebRequest request) {
        return new AdviceErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }
}
