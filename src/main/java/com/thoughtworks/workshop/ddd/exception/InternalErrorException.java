package com.thoughtworks.workshop.ddd.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class InternalErrorException extends ApplicationException {
    public InternalErrorException(String message) {
        super(INTERNAL_SERVER_ERROR, ApplicationErrorCodes.INTERNAL_SERVER_ERROR_CODE, message);
    }
}
