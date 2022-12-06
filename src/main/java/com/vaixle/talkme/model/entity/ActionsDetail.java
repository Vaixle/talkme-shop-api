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
@Table(name = "actions_detail")
public class ActionsDetail extends BaseEntity {

  @Serial private static final long serialVersionUID = 1L;

  String name;

  String type;

  @JsonProperty("hold_size")
  Long holdSize;

  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "ActionsDetail_id")
  List<Tariff> tariffs;

}
