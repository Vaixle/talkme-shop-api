package com.vaixle.talkme.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serial;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "shops")
public class Shop extends BaseEntity {

  @Serial private static final long serialVersionUID = 1L;

  String name;

  String image;

  @JsonProperty("gotolink")
  String goToLink;

  @JsonProperty("products_xml_link")
  String productsXMLLink;

  @ManyToMany(
          fetch = FetchType.LAZY,
          cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinTable(
          name = "program_categories",
          joinColumns = @JoinColumn(name = "program_id"),
          inverseJoinColumns = @JoinColumn(name = "category_id"))
  List<Category> categories;

  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "program_id")
  @JsonProperty("actions_detail")
  List<ActionsDetail> actionsDetail;

}
