package com.vaixle.talkme.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "rates")
public class Rate extends BaseEntity {

  @Serial private static final long serialVersionUID = 1L;

  @JsonProperty("price_s")
  Double price;

  Double size;

  String country;

  @JsonProperty("date_s")
  LocalDate date;

  @JsonProperty("is_percentage")
  Boolean isPercentage;

}
