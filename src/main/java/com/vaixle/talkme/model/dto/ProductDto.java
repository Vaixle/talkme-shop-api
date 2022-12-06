package com.vaixle.talkme.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.vaixle.talkme.model.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Product} entity
 */
@Data
@NoArgsConstructor
public class ProductDto implements Serializable {
    @JacksonXmlProperty(isAttribute = true)
    private  Long id;
    private  String name;
    @JacksonXmlProperty(localName = "vendor")
    private String model;
    private  Double price;
    @JacksonXmlProperty(localName = "picture")
    private  String image;
    @JacksonXmlProperty(localName = "url")
    private  String goToLink;
}