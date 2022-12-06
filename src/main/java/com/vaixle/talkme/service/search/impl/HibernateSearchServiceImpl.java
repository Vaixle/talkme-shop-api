package com.vaixle.talkme.service.search.impl;

import com.vaixle.talkme.exception.search.HibernateSearchInitializationException;
import com.vaixle.talkme.mapper.ProductMapper;
import com.vaixle.talkme.model.dto.ProductDto;
import com.vaixle.talkme.model.entity.Product;
import com.vaixle.talkme.service.search.HibernateSearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HibernateSearchServiceImpl implements HibernateSearchService {

    final ProductMapper productMapper;

    @PersistenceContext
    EntityManager entityManager;

    boolean isInitialized = false;

    public void initializeHibernateSearch() {
        try {
            var searchSession = Search.session(entityManager);
            var indexer = searchSession.massIndexer(Product.class);
            indexer.startAndWait();
            isInitialized = true;
        } catch (InterruptedException e) {
            throw new HibernateSearchInitializationException();
        }
    }

    private <T> SearchResult<T> search(Class<T> type, String searchTerm,int page, int size, String... fields) {
        if (!isInitialized) initializeHibernateSearch();
        var searchSession = Search.session(entityManager);
        return searchSession
                .search(type)
                .where(field -> field.match().fields(fields).matching(searchTerm))
                .fetch(page, size);
    }

    @Override
    @Transactional
    public List<ProductDto> searchForProducts(String searchTerm, int page, int size, String searchField) {
        var result = search(Product.class, searchTerm, page, size, searchField);
        return productMapper.productsToProductsDtos(result.hits());
    }

}
