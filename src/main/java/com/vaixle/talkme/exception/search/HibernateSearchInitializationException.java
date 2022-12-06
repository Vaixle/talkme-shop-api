package com.vaixle.talkme.exception.search;

import java.io.Serial;

public class HibernateSearchInitializationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_MESSAGE = "HibernateSearch initialization exception!";

    public HibernateSearchInitializationException() {
        super(DEFAULT_MESSAGE);
    }
}