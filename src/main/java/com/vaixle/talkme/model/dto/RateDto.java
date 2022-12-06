package com.vaixle.talkme.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** A DTO for the {@link com.vaixle.talkme.model.entity.Rate} entity */
@Data
@NoArgsConstructor
public class RateDto implements Serializable {
  @JsonProperty("tariff_id")
  Long tariffId;
  private Long id;
  @JsonProperty("price_s")
  private Double price;
  private Double size;
  private String country;
  @JsonProperty("date_s")
  private String date;
  @JsonProperty("is_percentage")
  private Boolean isPercentage;
}
