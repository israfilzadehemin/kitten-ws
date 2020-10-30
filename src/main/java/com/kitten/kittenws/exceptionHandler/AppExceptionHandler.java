package com.kitten.kittenws.exceptionHandler;

import com.kitten.kittenws.entity.KittenError;
import com.kitten.kittenws.exception.BreedNotFoundException;
import com.kitten.kittenws.exception.InvalidInputException;
import com.kitten.kittenws.exception.NoBreedsException;
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
    public ResponseEntity<?> handlerInvalidInput(InvalidInputException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new KittenError(exception.getMessage(), "400", "You entered invalid input"));
    }

    @ExceptionHandler(NoBreedsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNoBreeds(NoBreedsException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new KittenError(exception.getMessage(), "404", "There is no any breed in database"));
    }

    @ExceptionHandler(BreedNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handlerInvalidInput(BreedNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new KittenError(exception.getMessage(), "404", "Breed does not exist"));
    }

}
