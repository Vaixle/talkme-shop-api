package com.vaixle.talkme.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
  @JsonProperty("access_token")
  String accessToken;

  @JsonProperty("expires_in")
  String expiresIn;

  @JsonProperty("refresh_token")
  String refreshToken;


}
