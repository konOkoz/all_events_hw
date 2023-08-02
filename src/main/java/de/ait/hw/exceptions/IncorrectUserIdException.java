package de.ait.hw.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class IncorrectUserIdException extends RuntimeException {

    public IncorrectUserIdException(String message){
        super(message);
    }
}
