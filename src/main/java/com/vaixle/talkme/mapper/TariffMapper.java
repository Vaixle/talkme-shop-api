package com.vaixle.talkme.mapper;

import com.vaixle.talkme.model.dto.TariffDto;
import com.vaixle.talkme.model.entity.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = RateMapper.class,
    componentModel = "spring")
public interface TariffMapper {
  Tariff tariffDtoToTariff(TariffDto tariffDto);

  TariffDto tariffToTariffDto(Tariff tariff);

  List<Tariff> tariffDtosToTariffs(List<TariffDto> tariffDtos);

  List<TariffDto> tariffsToTariffDtos(List<Tariff> tariffs);
}
