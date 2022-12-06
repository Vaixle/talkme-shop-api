package com.vaixle.talkme.payload.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.vaixle.talkme.model.dto.ProductShopDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JacksonXmlRootElement(localName = "yml_catalog")
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponse {



//      @JacksonXmlElementWrapper(localName = "currencies")
//      @JacksonXmlProperty(localName = "currency")
//      CurrencyDto[] currencyDtos;

      @JacksonXmlProperty(localName = "shop")
      ProductShopDto productShopDto;


}
