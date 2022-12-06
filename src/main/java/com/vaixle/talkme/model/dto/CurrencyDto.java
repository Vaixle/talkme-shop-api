package com.vaixle.talkme.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyDto {
    @JacksonXmlProperty(isAttribute = true)
    Long id;
}
