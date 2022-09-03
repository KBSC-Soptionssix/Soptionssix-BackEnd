package com.soptionssix.api.utils.jwt;

import com.soptionssix.domain.error.SoptionsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    properties = {
        "jwt.secret=Ym95c29uIHNvcHRpb25zIHNpeCBqd3QgdGVzdCBzZWNyZXQga2V5",
        "jwt.token-validity-in-seconds=86400"
    }
)
class JwtTokenProviderTest {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    JwtTokenProviderTest(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @Test
    @DisplayName("유저 id 가 주어지고, 토큰을 제작하면, 유효한 토큰은 Decode 하여 Payload 내부 속성에 접근할 수 있다.")
    void createValidToken() {
        // given
        String expectedUserId = "userId";
        String token = this.jwtTokenProvider.createTokenOf(expectedUserId);
        // when
        PayLoad decodedToken = this.jwtTokenProvider.decodeJwtPayload(token);
        // then
        Assertions.assertInstanceOf(PayLoad.class, decodedToken);
        Assertions.assertInstanceOf(String.class, decodedToken.userId());
        Assertions.assertEquals(expectedUserId, decodedToken.userId());
    }

    @Test
    @DisplayName("null 값의 토큰이 주어지고, 토큰을 decode 하면, BadRequest 예외가 발생한다.")
    void validationTokenIsNull() {
        // given
        // when
        // then
        SoptionsException.BadRequest exception = Assertions.assertThrows(
            SoptionsException.BadRequest.class,
            () -> this.jwtTokenProvider.decodeJwtPayload(null)
        );
        Assertions.assertEquals(4000, exception.getErrorCode());
        Assertions.assertEquals("token is empty", exception.getMessage());
    }

    @Test
    @DisplayName("empty 값의 토큰이 주어지고, 토큰을 decode 하면, BadRequest 예외가 발생한다.")
    void validationTokenIsEmpty() {
        // given
        String emptyToken = "";
        // when
        // then
        SoptionsException.BadRequest exception = Assertions.assertThrows(
            SoptionsException.BadRequest.class,
            () -> this.jwtTokenProvider.decodeJwtPayload(emptyToken)
        );
        Assertions.assertEquals(4000, exception.getErrorCode());
        Assertions.assertEquals("token is empty", exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 형식의 토큰이 주어지고, 토큰을 decode 하면, BadRequest 예외가 발생한다.")
    @SuppressWarnings("checkstyle:LineLength")
    void validationTokenIsMalformed() {
        // given
        String malformedToken = "eyJhbGciOiJIUzI1NiJ9eyJleHAiOjE2NjIxOTU0OTksInVzZXJJZCI6InVzZXJJZCJ9.mQs_Qp5qSYvZ2XEfDCMCtc3REIgDsJXo7NfhoxmGjo81";
        // when
        // then
        SoptionsException.BadRequest exception = Assertions.assertThrows(
            SoptionsException.BadRequest.class,
            () -> this.jwtTokenProvider.decodeJwtPayload(malformedToken)
        );
        Assertions.assertEquals(4000, exception.getErrorCode());
    }

    @Test
    @DisplayName("잘못된 서명이된 토큰이 주어지고, 토큰을 decode 하면, Unauthenticated 예외가 발생한다.")
    @SuppressWarnings("checkstyle:LineLength")
    void validationTokenIsInvalidSignature() {
        // given
        String invalidSignatureToken = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NjIxOTU0OTksInVzZXJJZCI6InVzZXJJZCJ9.mQs_Qp5qSYvZ2XEfDCMCtc3REIgDsJXo7NfhoxmGjo81";
        // when
        // then
        SoptionsException.Unauthenticated exception = Assertions.assertThrows(
            SoptionsException.Unauthenticated.class,
            () -> this.jwtTokenProvider.decodeJwtPayload(invalidSignatureToken)
        );
        Assertions.assertEquals(4010, exception.getErrorCode());
    }

    @Test
    @DisplayName("만료된 토큰이 주어지고, 토큰을 decode 하면, ExpiredToken 예외가 발생한다.")
    @SuppressWarnings("checkstyle:LineLength")
    void validationTokenIsExpired() {
        // given
        String expiredToken = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NjIxMjA1MjgsInVzZXJJZCI6InVzZXJJZCJ9.JYNu1G4FUp3NBb7erA4hl2OG40hqsk0YPKOeNa7n9EI";
        // when
        // then
        SoptionsException.ExpiredToken exception = Assertions.assertThrows(
            SoptionsException.ExpiredToken.class,
            () -> this.jwtTokenProvider.decodeJwtPayload(expiredToken)
        );
        Assertions.assertEquals(4011, exception.getErrorCode());
    }
}