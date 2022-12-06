package com.vaixle.talkme.mapper;

import com.vaixle.talkme.model.dto.CategoryDto;
import com.vaixle.talkme.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = "spring")
public interface CategoryMapper {
  Category categoryDtoToCategory(CategoryDto categoryDto);

  CategoryDto categoryToCategoryDto(Category category);

  List<Category> categoryDtosToCategories(List<CategoryDto> categoryDtos);

  List<CategoryDto> categoriesToCategoryDtos(List<Category> categories);
}
