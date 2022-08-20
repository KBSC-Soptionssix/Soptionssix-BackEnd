package com.soptionssix.domain.error;

public class ErrorCode {

    public static final int BAD_REQUEST = 4000;
    public static final int UNAUTHORIZED_UNAUTHENTICATED = 4010;
    public static final int UNAUTHORIZED_EXPIRED_TOKEN = 4011;
    public static final int NOTFOUND = 4040;
    public static final int INTERNAL_SERVER_ERROR = 5000;

    private ErrorCode() {
    }
}
