package com.vaixle.talkme.service.impl;

import com.vaixle.talkme.repository.AdmitadCredentialRepository;
import com.vaixle.talkme.service.AdmitadCredentialService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdmitadCredentialServiceImpl implements AdmitadCredentialService {
  AdmitadCredentialRepository admitadCredentialRepository;

  @Override
  public String getAccessToken() {
    return admitadCredentialRepository.getAccessToken();
  }
}
