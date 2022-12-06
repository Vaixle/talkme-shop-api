package com.vaixle.talkme.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vaixle.talkme.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShopsController { // Todo: bad naming

    ShopService shopService;

    // todo: all this logic mustn't be at controller
    @GetMapping("/shops")
    ResponseEntity<?> getShops(@RequestParam(required = false) Long limit) throws JsonProcessingException {
        return null;
    }

}
