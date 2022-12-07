package com.vaixle.talkme.configuration;

import com.vaixle.talkme.configuration.authentication.CustomAuthenticationEntryPoint;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityConfig {

  CustomAuthenticationEntryPoint authenticationEntryPoint;

  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig)
      throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors().disable()
        .csrf().disable()
        .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
        .and().formLogin().loginProcessingUrl("/sign-in")
        .and().logout().logoutUrl("/sign-out")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .and().authorizeRequests().antMatchers("/sign-in").permitAll()
        .antMatchers("/api/shops/edit").hasRole("ADMIN")
        .anyRequest().authenticated();
    return http.build();
  }
}
