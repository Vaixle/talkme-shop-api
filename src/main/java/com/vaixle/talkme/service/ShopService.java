package com.vaixle.talkme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vaixle.talkme.payload.request.EditShopRequest;
import org.springframework.http.ResponseEntity;

public interface ShopService {

    void unloadShops(Long limit) throws JsonProcessingException;

    ResponseEntity<?> getShops(int page, int size);

    void editShop(EditShopRequest editShopRequest);

}
