package com.vaixle.talkme.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "products")
public class Product extends BaseEntity {

  @Serial private static final long serialVersionUID = 1L;

  String name;

  String model;

  Double price;

  String image;

  @JsonProperty("gotolink")
  String goToLink;
}
