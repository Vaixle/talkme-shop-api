package com.vaixle.talkme.mapper;

import com.vaixle.talkme.model.dto.ProductDto;
import com.vaixle.talkme.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product product);

    List<Product> productDtosToProducts(List<ProductDto > productDtos);

    List<ProductDto> productsToProductsDtos(List<Product> products);
}
