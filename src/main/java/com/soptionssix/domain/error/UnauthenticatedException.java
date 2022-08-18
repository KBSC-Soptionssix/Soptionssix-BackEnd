package com.soptionssix.domain.error;

import com.soptionssix.domain.util.ErrorMessage;

public class UnauthenticatedException extends IllegalArgumentException {
    public UnauthenticatedException() {
        super(ErrorMessage.UNAUTHENTICATED);
    }
}
