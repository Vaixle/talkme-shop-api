package com.vaixle.talkme.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** A DTO for the {@link com.vaixle.talkme.model.entity.Category} entity */
@Data
@NoArgsConstructor
public class CategoryDto implements Serializable {
  private Long id;
  private String name;
  private String language;
}
