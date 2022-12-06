package com.vaixle.talkme.exception.security;

import java.io.Serial;

public class AdmitadCredentialGetTokenException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_MESSAGE = "Get tokens exception!";

    public AdmitadCredentialGetTokenException() {
        super(DEFAULT_MESSAGE);
    }

}
