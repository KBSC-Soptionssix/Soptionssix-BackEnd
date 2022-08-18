package com.soptionssix.domain.util;

public final class ErrorMessage {
    public static final String BAD_REQUEST = "잘못된 요청입니다.";
    public static final String UNAUTHENTICATED = "인증되지 않은 사용자입니다.";
    public static final String EXPIRED_TOKEN = "토큰이 만료되었습니다.";
    public static final String NOT_FOUND = "요청한 자원이 존재하지 않습니다.";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 오류입니다.";


    private ErrorMessage() {
    }
}
