package com.seriouscompanyname.serverhospital.dto.exception;

import com.seriouscompanyname.serverhospital.exception.NoSuchPageException;

public class NoSuchPageExceptionDTO extends TransferableException {

    public NoSuchPageExceptionDTO(NoSuchPageException e) {
        super(e.getMessage());
    }
}
