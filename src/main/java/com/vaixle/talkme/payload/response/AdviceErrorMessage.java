package com.vaixle.talkme.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AdviceErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
