package com.kitten.kittenws.exceptionHandler;

import com.kitten.kittenws.entity.KittenError;
import com.kitten.kittenws.exception.BreedNotFoundException;
import com.kitten.kittenws.exception.InvalidInputException;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class AppExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public KittenError handlerInvalidInput(InvalidInputException exception) {
        return new KittenError(exception.getUrl(), "400", "You entered invalid input");
    }

    @ExceptionHandler(BreedNotFoundException.class)
    public ResponseEntity<?> handlerInvalidInput(BreedNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new KittenError(exception.getUrl(), "404", "Breed does not exist"));
    }

}
