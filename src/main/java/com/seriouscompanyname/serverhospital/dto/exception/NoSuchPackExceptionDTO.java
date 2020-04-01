package com.seriouscompanyname.serverhospital.dto.exception;

import com.seriouscompanyname.serverhospital.exception.NoSuchPackException;

public class NoSuchPackExceptionDTO extends TransferableException {

    public NoSuchPackExceptionDTO(NoSuchPackException e) {
        super(e.getMessage());
    }
}
