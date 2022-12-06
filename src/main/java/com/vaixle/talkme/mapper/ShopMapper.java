package com.vaixle.talkme.mapper;

import com.vaixle.talkme.model.dto.ShopDto;
import com.vaixle.talkme.model.entity.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {CategoryMapper.class, ActionsDetailMapper.class},
    componentModel = "spring")
public interface ShopMapper {
  Shop shopDtoToShop(ShopDto shopDto);

  ShopDto shopToShopDto(Shop shop);

  List<Shop> shopDtosToShops(List<ShopDto> shopDtos);

  List<ShopDto> shopsToShopDtos(List<Shop> shops);
}
