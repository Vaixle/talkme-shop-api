package com.vaixle.talkme.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaixle.talkme.model.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/** A DTO for the {@link Shop} entity */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto implements Serializable {
  private Long id;
  private String name;
  private String image;
  @JsonProperty("gotolink")
  private String goToLink;
  @JsonProperty("products_xml_link")
  private String productsXMLLink;
  private List<CategoryDto> categories;
  @JsonProperty("actions_detail")
  private List<ActionsDetailDto> actionsDetail;
}
