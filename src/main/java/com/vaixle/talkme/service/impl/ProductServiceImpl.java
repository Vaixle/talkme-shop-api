package com.vaixle.talkme.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.vaixle.talkme.mapper.ProductMapper;
import com.vaixle.talkme.model.dto.ProductDto;
import com.vaixle.talkme.model.entity.Product;
import com.vaixle.talkme.model.entity.Shop;
import com.vaixle.talkme.payload.response.ProductsResponse;
import com.vaixle.talkme.repository.ProductRepository;
import com.vaixle.talkme.repository.ShopRepository;
import com.vaixle.talkme.service.ProductService;
import com.vaixle.talkme.service.search.HibernateSearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    RestTemplate restTemplate;

    ProductMapper productMapper;

    ProductRepository productRepository;

    ShopRepository shopRepository;

    HibernateSearchService hibernateSearchService;

    @Override
    @Transactional
    public void unloadProducts() {

        List<Shop> shops = shopRepository.findAll();

        shops.stream().map(Shop::getProductsXMLLink).filter(Objects::nonNull).forEach(link-> {
            try {
                saveEntities(link);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void saveEntities(String link) throws JsonProcessingException {

        ResponseEntity<String> response = restTemplate.exchange(link, HttpMethod.GET, null, String.class);

        ProductsResponse productsResponse = new XmlMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(response.getBody(), ProductsResponse.class);

        List<Product> products = productMapper.productDtosToProducts(productsResponse.getProductShopDto().getOffers());

        productRepository.saveAll(products);
    }

    @Override
    @Transactional
    public ResponseEntity<?> getProducts(String searchTerm, String field, int page, int size) {
        List<ProductDto> shops = hibernateSearchService.searchForProducts(searchTerm, page, size, field);
        return ResponseEntity.ok().body(shops);
    }
}
