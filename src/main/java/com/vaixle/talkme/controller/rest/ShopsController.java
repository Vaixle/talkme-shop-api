package com.vaixle.talkme.controller.rest;

import com.vaixle.talkme.service.ShopService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShopsController {

    ShopService shopService;

    @GetMapping("/shops")
    ResponseEntity<?> getShops(@RequestParam int page,
                               @RequestParam int size)  {
        return shopService.getShops(page, size);
    }

}
