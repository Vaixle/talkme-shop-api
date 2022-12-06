package com.vaixle.talkme.mapper;

import com.vaixle.talkme.model.dto.RateDto;
import com.vaixle.talkme.model.entity.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RateMapper {
  Rate rateDtoToRate(RateDto rateDto);

  RateDto rateToRateDto(Rate rate);

  List<Rate> rateDtosToRates(List<RateDto> rateDtos);

  List<RateDto> ratesToRateDtos(List<Rate> rates);
}
