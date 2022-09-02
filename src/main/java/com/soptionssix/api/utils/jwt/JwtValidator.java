package com.soptionssix.api.utils.jwt;

import com.soptionssix.domain.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
