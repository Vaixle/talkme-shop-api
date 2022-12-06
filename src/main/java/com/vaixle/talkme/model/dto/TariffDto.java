package com.vaixle.talkme.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/** A DTO for the {@link com.vaixle.talkme.model.entity.Tariff} entity */
@Data
@NoArgsConstructor
public class TariffDto implements Serializable {
  private Long id;
  @JsonProperty("action_id")
  private Long actionId;
  private String name;
  private List<RateDto> rates;


}
