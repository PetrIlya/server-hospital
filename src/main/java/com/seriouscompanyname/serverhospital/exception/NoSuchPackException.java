package com.seriouscompanyname.serverhospital.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class NoSuchPackException extends RuntimeException {

    public NoSuchPackException(String message) {
        super(message);
    }
}
