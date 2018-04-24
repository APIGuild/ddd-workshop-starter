package com.thoughtworks.workshop.ddd.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ApplicationException extends RuntimeException {
    private final HttpStatus status;
    private final String code;
    private final String message;
}
