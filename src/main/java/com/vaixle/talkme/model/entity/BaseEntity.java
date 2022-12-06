package com.vaixle.talkme.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@Indexed
public abstract class BaseEntity implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id Long id;

  @GenericField
  @UpdateTimestamp
  ZonedDateTime updateDate;
}
