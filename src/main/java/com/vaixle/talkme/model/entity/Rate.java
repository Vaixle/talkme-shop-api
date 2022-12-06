package com.vaixle.talkme.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Table;
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

  Double price;

  Double size;

  String country;

  LocalDate date;

  Boolean isPercentage;

}
