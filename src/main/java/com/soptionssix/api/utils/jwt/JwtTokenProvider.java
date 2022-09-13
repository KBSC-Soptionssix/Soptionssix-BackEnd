package com.soptionssix.api.utils.jwt;

import com.soptionssix.domain.error.SoptionsException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtTokenProvider {

    private static final String CLAIM_KEY_OF_USER_ID = "userId";
    private final long tokenValidityOfMillisecond;

    private final Key key;

    public JwtTokenProvider(
        @Value("${jwt.secret}") String secret,
        @Value("${jwt.token-validity-in-seconds}") long tokenValidityOfMillisecond
    ) {
        byte[] secretKey = secret.getBytes(StandardCharsets.UTF_8);
        this.key = Keys.hmacShaKeyFor(secretKey);
        this.tokenValidityOfMillisecond = tokenValidityOfMillisecond;
    }

    public String createTokenOf(final String userId) {
        return Jwts.builder()
            .signWith(key, SignatureAlgorithm.HS256)
            .setExpiration(createExpiredTime())
            .claim(CLAIM_KEY_OF_USER_ID, userId)
            .compact();

    }

    private Date createExpiredTime() {
        long currentTime = new Date().getTime();
        Date expiredTime = new Date(currentTime + this.tokenValidityOfMillisecond);
        log.debug("new Token ExpiredTime : " + expiredTime);
        return expiredTime;
    }

    public PayLoad decodeJwtPayload(final String token) {
        validationToken(token);
        Claims claims = parseClaimsOfJwt(token).getBody();
        return new PayLoad(
            claims.get(CLAIM_KEY_OF_USER_ID, String.class)
        );
    }

    private void validationToken(String token) {
        if (token == null || StringUtils.isEmpty(token)) {
            throw new SoptionsException.BadRequest("token is empty");
        }
    }

    private JwtParser getSigningJwtParser() {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build();
    }

    private Jws<Claims> parseClaimsOfJwt(final String token) {
        try {
            return getSigningJwtParser().parseClaimsJws(token);
        } catch (ExpiredJwtException expiredJwtException) {
            throw new SoptionsException.ExpiredToken();
        } catch (MalformedJwtException malformedJwtException) {
            throw new SoptionsException.BadRequest(malformedJwtException.getMessage());
        } catch (JwtException jwtException) {
            throw new SoptionsException.Unauthenticated(jwtException.getMessage());
        }
    }
}
