package com.vaixle.talkme.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vaixle.talkme.configuration.property.AdmitadProperty;
import com.vaixle.talkme.service.ProductService;
import com.vaixle.talkme.service.ShopService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ScheduleConfiguration {

    ShopService shopService;

    ProductService productService;

    AdmitadProperty admitadProperty;

    @Scheduled(cron = "0 * * ? * *")
    private void scheduleUnloadShopsTask() throws JsonProcessingException {
        shopService.unloadShops(admitadProperty.getLimit());
    }


    @Scheduled(cron = "0 * * ? * *")
    private void scheduleUnloadProducts() throws JsonProcessingException {
        productService.unloadProducts();
    }

}
