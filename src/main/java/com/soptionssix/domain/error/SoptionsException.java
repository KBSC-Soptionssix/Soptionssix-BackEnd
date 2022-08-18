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
        public BadRequest(String message) {
            super(ErrorCode.BAD_REQUEST, message);
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

    // http error status 404
    public static final class NotFound extends SoptionsException {
        public NotFound() {
            super(ErrorCode.NOTFOUND, "Not Found");
        }
    }

    // http error status 500
    public static final class InternalServerError extends SoptionsException {
        public InternalServerError(String message) {
            super(ErrorCode.INTERNAL_SERVER_ERROR, message);
        }
    }
}
