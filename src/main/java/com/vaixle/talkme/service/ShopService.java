package com.vaixle.talkme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface ShopService {

    void unloadShops(Long limit) throws JsonProcessingException;

    ResponseEntity<?> getShops(int page, int size);

}
