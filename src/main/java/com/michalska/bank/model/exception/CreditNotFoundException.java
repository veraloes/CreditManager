package com.michalska.bank.model.exception;

import java.text.MessageFormat;

public class CreditNotFoundException extends RuntimeException {
    public CreditNotFoundException(Long id) {
        super(MessageFormat.format("Could not find credit with id: {0}", id));
    }
}
