package com.vaixle.talkme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    void unloadProducts() throws JsonProcessingException;

    ResponseEntity<?> getProducts(String searchTerm, String field, int page, int size);
}
