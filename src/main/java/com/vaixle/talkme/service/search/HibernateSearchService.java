package com.vaixle.talkme.service.search;

import com.vaixle.talkme.model.dto.ProductDto;

import java.util.List;

public interface HibernateSearchService {

    List<ProductDto> searchForProducts(String searchTerm, int page, int size, String searchField);
}
