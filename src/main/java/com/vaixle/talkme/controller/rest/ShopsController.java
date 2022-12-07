package com.vaixle.talkme.controller.rest;

import com.vaixle.talkme.payload.request.EditShopRequest;
import com.vaixle.talkme.service.ShopService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShopsController {

    ShopService shopService;

    @GetMapping("/shops")
    public ResponseEntity<?> getShops(@RequestParam int page,
                               @RequestParam int size)  {
        return shopService.getShops(page, size);
    }

    @PostMapping("/shops/edit")
    public void editShop(@RequestBody EditShopRequest editShopRequest)  {
        shopService.editShop(editShopRequest);
    }

}
