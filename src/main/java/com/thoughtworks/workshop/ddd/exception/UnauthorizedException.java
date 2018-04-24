package com.thoughtworks.workshop.ddd.exception;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public abstract class UnauthorizedException extends ApplicationException {
    public UnauthorizedException(String code, String message) {
        super(UNAUTHORIZED, code, message);
    }
}
