package com.vaixle.talkme.model.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProductShopDto {

    String name;
    String url;
    @JacksonXmlElementWrapper(localName = "offers")
    @JacksonXmlProperty(localName = "offer")
    List<ProductDto> offers;
}
