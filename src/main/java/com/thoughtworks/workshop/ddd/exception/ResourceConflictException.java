package com.thoughtworks.workshop.ddd.exception;

import static org.springframework.http.HttpStatus.CONFLICT;

public abstract class ResourceConflictException extends ApplicationException {
    public ResourceConflictException(String code, String message) {
        super(CONFLICT, code, message);
    }
}
