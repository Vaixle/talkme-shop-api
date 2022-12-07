package com.vaixle.talkme;

import com.vaixle.talkme.configuration.property.AdmitadProperty;
import com.vaixle.talkme.model.entity.ERole;
import com.vaixle.talkme.model.entity.Role;
import com.vaixle.talkme.model.entity.User;
import com.vaixle.talkme.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableConfigurationProperties(AdmitadProperty.class)
@AllArgsConstructor
public class TalkMeApplication {

  private PasswordEncoder passwordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(TalkMeApplication.class, args);
  }

  @Bean
  @Transactional
  public CommandLineRunner dataLoader(UserRepository userRepository) {
    return args -> {
      User user = new User();
      if (!userRepository.existsByUsername("peter")) {
        user.setUsername("peter");
        user.setPassword(passwordEncoder.encode("admin"));
        user.addRole(new Role(ERole.ROLE_USER));
        user.addRole(new Role(ERole.ROLE_ADMIN));
        userRepository.save(user);
      }

      if (!userRepository.existsByUsername("ivan")) {
        user = new User();
        user.setUsername("ivan");
        user.setPassword(passwordEncoder.encode("ivan"));
        user.addRole(new Role(ERole.ROLE_USER));
        userRepository.save(user);
      }
    };
  }
}
