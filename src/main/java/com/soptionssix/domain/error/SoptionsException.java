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

    // http error status 400
    public static final class BadRequest extends SoptionsException {
        public BadRequest(int errorCode, String message) {
            super(errorCode, message);
        }

        public BadRequest(String message) {
            this(ErrorCode.BAD_REQUEST, "Bad Request");
        }

        public BadRequest() {
            this("Bad Request");
        }
    }

    // http error status 401
    public static final class Unauthenticated extends SoptionsException {
        public Unauthenticated() {
            super(ErrorCode.UNAUTHORIZED_UNAUTHENTICATED, "Unauthenticated");
        }
    }

    public static final class ExpiredToken extends SoptionsException {
        public ExpiredToken() {
            super(ErrorCode.UNAUTHORIZED_EXPIRED_TOKEN, "Expired Token");
        }
    }
}
