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
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

    public String decodeJwtToken(final String token) {
        validationToken(token);
        return parseClaimsOfJwt(token).getBody()
            .get(CLAIM_KEY_OF_USER_ID)
            .toString();
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
