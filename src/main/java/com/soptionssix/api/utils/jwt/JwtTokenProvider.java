package com.soptionssix.api.utils.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
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

    public String getJwtToken(final String userId) {
        return Jwts.builder()
            .claim(CLAIM_KEY_OF_USER_ID, userId)
            .signWith(key, SignatureAlgorithm.ES256)
            .setExpiration(createExpiredTime())
            .compact();

    }

    private Date createExpiredTime() {
        long currentTime = new Date().getTime();
        Date expiredTime = new Date(currentTime + this.tokenValidityOfMillisecond);
        log.debug("new Token ExpiredTime : " + expiredTime);
        return expiredTime;
    }
}
