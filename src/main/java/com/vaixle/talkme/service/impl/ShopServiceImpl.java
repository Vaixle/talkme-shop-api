package com.vaixle.talkme.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaixle.talkme.configuration.property.AdmitadProperty;
import com.vaixle.talkme.exception.shop.ShopNotFoundException;
import com.vaixle.talkme.mapper.ShopMapper;
import com.vaixle.talkme.model.entity.Shop;
import com.vaixle.talkme.payload.request.EditShopRequest;
import com.vaixle.talkme.payload.response.ProgramsResponse;
import com.vaixle.talkme.repository.ShopRepository;
import com.vaixle.talkme.service.AdmitadCredentialService;
import com.vaixle.talkme.service.ShopService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShopServiceImpl implements ShopService {

    RestTemplate restTemplate;

    AdmitadCredentialService admitadCredentialService;

    AdmitadProperty admitadProperty;

    ShopMapper shopMapper;

    ShopRepository shopRepository;

    @Override
    @Transactional
    public void unloadShops(Long limit) throws JsonProcessingException {

        ResponseEntity<String> response =
                restTemplate.exchange(
                        AdmitadProperty.URL_PROGRAM,
                        HttpMethod.GET,
                        admitadProperty.getShopRequestHeaders(admitadCredentialService.getAccessToken()),
                        String.class,
                        admitadProperty.getShopRequestParams(limit));

        ProgramsResponse results = new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        .readValue(response.getBody(), ProgramsResponse.class);

        List<Shop> shops = shopMapper.shopDtosToShops(results.getShopDtos());

        shopRepository.saveAll(shops);
    }

    @Override
    @Transactional
    public ResponseEntity<?> getShops(int page, int size) {
        PageRequest pageReq = PageRequest.of(page, size);
        List<Shop> shops = shopRepository.findAll(pageReq).getContent();
        return ResponseEntity.ok().body(shopMapper.shopsToShopDtos(shops));
    }

    @Override
    @Transactional
    public void editShop(EditShopRequest editShopRequest) {;
        Long id = editShopRequest.getId();
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new ShopNotFoundException(id));
        shop.setName(editShopRequest.getName());
        shop.setImage(editShopRequest.getImage());
        shopRepository.save(shop);
    }
}
