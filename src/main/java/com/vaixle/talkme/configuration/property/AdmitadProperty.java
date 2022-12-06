package com.vaixle.talkme.configuration.property;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;


@ConfigurationProperties(prefix = "admitad")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdmitadProperty {
  public static final String URL = "https://api.admitad.com/token/";
  public static final String URL_PROGRAM = "https://api.admitad.com/advcampaigns/website/2090016/?limit={limit}";
  private static final String PARAMETER_GRANT_TYPE = "grant_type";
  private static final String PARAMETER_CLIENT_ID = "client_id";
  private static final String PARAMETER_SCOPE = "scope";
  private static final String PARAMETER_LIMIT = "limit";
  private static final String PARAMETER_REFRESH_TOKEN = "refresh_token";
  private static final String HEADER_AUTHORIZATION = "Authorization";
  private static final String HEADER_PREFIX_BASIC = "Basic ";
  private static final String HEADER_PREFIX_BEARER = "Bearer ";

  String accessGrantType;
  String refreshGrantType;
  String clientId;
  String scope;
  String authorizationToken;

  Long limit;

  public HttpEntity<MultiValueMap<String, String>> getDefaultAccessRequest() {
    var headers = new HttpHeaders();
    var body = new LinkedMultiValueMap<String, String>();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.add(HEADER_AUTHORIZATION, HEADER_PREFIX_BASIC + authorizationToken);
    body.add(PARAMETER_GRANT_TYPE, accessGrantType);
    body.add(PARAMETER_CLIENT_ID, clientId);
    body.add(PARAMETER_SCOPE, scope);
    return new HttpEntity<>(body, headers);
  }

  public HttpEntity<MultiValueMap<String, String>> getShopRequestHeaders(String accessToken) {
    var headers = new HttpHeaders();
    headers.add(HEADER_AUTHORIZATION, HEADER_PREFIX_BEARER + accessToken);
    return new HttpEntity<>(headers);
  }

  public Map<String, String> getShopRequestParams(Long limit) {
    Map<String, String> params = new HashMap<>();
    params.put(PARAMETER_LIMIT, limit.toString());
    return params;
  }

  public Map<String, String> getDefaultRefreshParameters(String refreshToken) {
    return Map.of(
        PARAMETER_GRANT_TYPE,
        refreshGrantType,
        PARAMETER_CLIENT_ID,
        clientId,
        PARAMETER_REFRESH_TOKEN,
        refreshToken);
  }
}
