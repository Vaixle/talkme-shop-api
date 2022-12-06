package com.vaixle.talkme.mapper;

import com.vaixle.talkme.model.dto.ActionsDetailDto;
import com.vaixle.talkme.model.entity.ActionsDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = TariffMapper.class,
    componentModel = "spring")
public interface ActionsDetailMapper {
  ActionsDetail actionsDetailDtoToActionsDetail(ActionsDetailDto actionsDetailDto);

  ActionsDetailDto actionsDetailToActionsDetailDto(ActionsDetail actionsDetail);

  List<ActionsDetail> actionsDetailDtosToActionsDetails(List<ActionsDetailDto> actionsDetailDtos);

  List<ActionsDetailDto> ActionsDetailsToActionsDetailDtos(List<ActionsDetail> actionsDetails);
}
