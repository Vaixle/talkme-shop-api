package com.vaixle.talkme.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaixle.talkme.model.dto.ShopDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProgramsResponse {
  @JsonProperty("results")
  List<ShopDto> shopDtos;
}
