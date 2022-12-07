package com.vaixle.talkme.repository;

import com.vaixle.talkme.model.entity.ERole;
import com.vaixle.talkme.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(ERole name);
}
