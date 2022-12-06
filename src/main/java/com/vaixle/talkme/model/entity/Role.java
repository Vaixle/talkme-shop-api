package com.vaixle.talkme.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
    name = "roles",
    uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Role implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Enumerated(EnumType.STRING)
  ERole name;

  @CreationTimestamp ZonedDateTime createDate;

  @UpdateTimestamp ZonedDateTime updateDate;

  public Role(ERole role) {
    this.name = role;
  }
}
