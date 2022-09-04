package com.soptionssix.api.utils.jwt;

import com.soptionssix.domain.error.SoptionsException;
import com.soptionssix.domain.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class JwtValidator {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Autowired
    public JwtValidator(
        JwtTokenProvider jwtTokenProvider,
        UserService userService
    ) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @Before("@annotation(com.soptionssix.api.utils.jwt.RequiredJwtToken)")
    public void validateToken() {
        ServletRequestAttributes requestAttributes =
            (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        final String token = request.getHeader("token");
        final PayLoad payload = jwtTokenProvider.decodeJwtPayload(token);
        validatePayLoad(payload);
    }

    private void validatePayLoad(PayLoad payLoad) {
        final String userId = payLoad.userId();
        if (!this.userService.hasUser(userId)) {
            throw new SoptionsException.Unauthenticated("can not find user authentication");
        }
    }
}
