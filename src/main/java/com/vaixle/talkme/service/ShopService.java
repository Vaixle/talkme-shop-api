package com.vaixle.talkme.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ShopService {

    void unloadShops(Long limit) throws JsonProcessingException;

}
