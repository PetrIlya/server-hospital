package com.seriouscompanyname.serverhospital.controller;

import com.seriouscompanyname.serverhospital.exception.NoSuchPackException;
import com.seriouscompanyname.serverhospital.exception.NoSuchPageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = NoSuchPackException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NoSuchPackException processException(NoSuchPackException e) {
        return e;
    }

    @ExceptionHandler(value = NoSuchPageException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NoSuchPageException processException(NoSuchPageException e) {
        return e;
    }
}
