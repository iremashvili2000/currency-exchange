package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class WebExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BadDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity handlerBadDataException(BadDataException badDataException){
        return new ResponseEntity(badDataException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
