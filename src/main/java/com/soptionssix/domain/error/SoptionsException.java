package com.soptionssix.domain.error;

public sealed class SoptionsException extends RuntimeException {
    protected final int errorCode;

    public SoptionsException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
