package com.vaixle.talkme.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/** A DTO for the {@link com.vaixle.talkme.model.entity.ActionsDetail} entity */
@Data
@NoArgsConstructor
public class ActionsDetailDto implements Serializable {
  List<TariffDto> tariffs;
  private Long id;
  private String name;
  private String type;
  @JsonProperty("hold_size")
  private Double holdSize;
}
