package com.soptionssix.api.utils.jwt;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider implements InitializingBean {

    private static final String CLAIM_KEY_OF_USER_ID = "userId";
    private final String secret;
    private final long tokenValidityOfMillisecond;

    private Key key;

    public JwtTokenProvider(
        @Value("${jwt.secret}") String secret,
        @Value("${jwt.token-validity-in-seconds}") long tokenValidityOfMillisecond
    ) {
        this.secret = secret;
        this.tokenValidityOfMillisecond = tokenValidityOfMillisecond;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] decodedKey = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(decodedKey);
    }
}
