package com.vaixle.talkme.controller.rest;

import com.vaixle.talkme.service.ProductService;
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
public class ProductController {

    ProductService productService;

    @GetMapping("/products")
    ResponseEntity<?> getShops(@RequestParam(name = "search") String searchTerm,
                               @RequestParam String field,
                               @RequestParam int page,
                               @RequestParam int size)  {
        return productService.getProducts(searchTerm, field, page, size);
    }
}
