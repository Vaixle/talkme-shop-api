package com.vaixle.talkme.exception.security;

import java.io.Serial;

public class AdmitadCredentialRefreshTokenException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_MESSAGE = "Refresh tokens exception!";

    public AdmitadCredentialRefreshTokenException() {
        super(DEFAULT_MESSAGE);
    }
}
