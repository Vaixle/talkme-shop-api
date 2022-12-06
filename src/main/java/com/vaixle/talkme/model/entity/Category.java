package com.vaixle.talkme.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serial;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "categories")
public class Category extends BaseEntity {

  @Serial private static final long serialVersionUID = 1L;

  String name;

  String language;



//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "program_id")
//  Program program;
}
