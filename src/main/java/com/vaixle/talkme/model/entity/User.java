package com.vaixle.talkme.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
    name = "user",
    uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String username;

  String password;

  @ManyToMany(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  @ToString.Exclude
  private Set<Role> roles = new HashSet<>();

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public void addRole(Role role) {
    roles.add(role);
  }

  public void removeRole(Role role) {
    roles.remove(role);
  }
}
