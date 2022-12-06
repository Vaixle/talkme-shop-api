package com.vaixle.talkme.configuration;

import com.vaixle.talkme.configuration.authentication.CustomAuthenticationEntryPoint;
import com.vaixle.talkme.filter.AuthTokenFilter;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityConfig {

  CustomAuthenticationEntryPoint authenticationEntryPoint;

  AuthTokenFilter authTokenFilter;

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
        .and().authorizeRequests().antMatchers("/sign-in").permitAll()
        .anyRequest().authenticated();
    http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
