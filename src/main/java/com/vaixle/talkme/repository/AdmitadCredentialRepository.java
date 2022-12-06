package com.vaixle.talkme.repository;

public interface AdmitadCredentialRepository {

  String getAccessToken();

  String refreshToken();

  boolean isExpired();
}
