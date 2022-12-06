package com.vaixle.talkme.repository.impl;

import com.vaixle.talkme.configuration.property.AdmitadProperty;
import com.vaixle.talkme.exception.security.AdmitadCredentialGetTokenException;
import com.vaixle.talkme.payload.response.JwtResponse;
import com.vaixle.talkme.repository.AdmitadCredentialRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Repository
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdmitadCredentialRepositoryImpl implements AdmitadCredentialRepository {
  final RestTemplate restTemplate;
  final AdmitadProperty admitadProperty;

  String accessToken;
  String refreshToken;
  LocalDateTime accessTokenExpiration;

  public AdmitadCredentialRepositoryImpl(RestTemplate restTemplate, AdmitadProperty admitadProperty) {
    this.restTemplate = restTemplate;
    this.admitadProperty = admitadProperty;
    var request = admitadProperty.getDefaultAccessRequest();
    var response = restTemplate.postForObject(AdmitadProperty.URL, request, JwtResponse.class);
    if (Objects.nonNull(response)) {
      this.accessToken = response.getAccessToken();
      this.refreshToken = response.getRefreshToken();
      this.accessTokenExpiration =
          LocalDateTime.now().plus(Long.parseLong(response.getExpiresIn()), ChronoUnit.MILLIS);
    } else {
      throw new AdmitadCredentialGetTokenException();
    }
  }

  @Override
  public String getAccessToken() {
    return isExpired() ? refreshToken() : accessToken;
  }

  @Override
  public String refreshToken() {
    var parameters = admitadProperty.getDefaultRefreshParameters(refreshToken);
    var response =
        restTemplate.postForObject(AdmitadProperty.URL, null, JwtResponse.class, parameters);
    if (Objects.nonNull(response)) {
      this.accessToken = response.getAccessToken();
      this.refreshToken = response.getRefreshToken();
      this.accessTokenExpiration =
          LocalDateTime.now().plus(Long.parseLong(response.getExpiresIn()), ChronoUnit.MILLIS);
    } else {
      throw new AdmitadCredentialGetTokenException();
    }
    return accessToken;
  }

  @Override
  public boolean isExpired() {
    return accessTokenExpiration.isBefore(LocalDateTime.now());
  }
}
