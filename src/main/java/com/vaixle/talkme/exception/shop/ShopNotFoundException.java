package com.vaixle.talkme.exception.shop;

import java.io.Serial;

public class ShopNotFoundException  extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_MESSAGE = "Shop not found exception!";

    private static final String MESSAGE_WITH_ID = "Shop with id %d not found exception!";


    public ShopNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ShopNotFoundException(Long id) {
        super(String.format(MESSAGE_WITH_ID, id));
    }
}
