package com.kitten.kittenws.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends KittenWsException {
    private final String url;
}