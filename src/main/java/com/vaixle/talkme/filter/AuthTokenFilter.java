package com.vaixle.talkme.filter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Todo: class for remove

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class AuthTokenFilter extends OncePerRequestFilter {

//  AdmitadCredentialRepository admitadCredentialRepository;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

//    admitadCredentialRepository.isExpired();

    filterChain.doFilter(request, response);
  }
}
