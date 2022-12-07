package com.vaixle.talkme.configuration;

import com.vaixle.talkme.configuration.property.AdmitadProperty;
import com.vaixle.talkme.service.ProductService;
import com.vaixle.talkme.service.ShopService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ScheduleConfiguration {

    ShopService shopService;

    ProductService productService;

    AdmitadProperty admitadProperty;

//    @Scheduled(cron = "${admitad.schedule-update-shops}")
//    private void scheduleUnloadShopsTask() throws JsonProcessingException {
//        shopService.unloadShops(admitadProperty.getLimit());
//    }
//
//    @Scheduled(cron = "${admitad.schedule-update-products}")
//    private void scheduleUnloadProducts() throws JsonProcessingException {
//        productService.unloadProducts();
//    }
}
