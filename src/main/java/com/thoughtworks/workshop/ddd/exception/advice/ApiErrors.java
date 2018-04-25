package com.thoughtworks.workshop.ddd.exception.advice;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(NON_EMPTY)
public class ApiErrors {
    private List<ApiError> errors;
}
