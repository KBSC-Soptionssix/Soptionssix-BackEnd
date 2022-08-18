package com.soptionssix.api.contoller;

import com.soptionssix.domain.error.ExpiredTokenException;
import com.soptionssix.domain.error.UnauthenticatedException;
import com.soptionssix.domain.util.ErrorMessage;
import com.soptionssix.api.dto.ErrorResponse;
import com.soptionssix.domain.util.ErrorStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundUriError() {
        return new ErrorResponse(
                ErrorStatus.NOTFOUND,
                ErrorMessage.NOT_FOUND
        );
    }

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleUnauthenticatedError() {
        return new ErrorResponse(
                ErrorStatus.UNAUTHORIZED_UNAUTHENTICATED,
                ErrorMessage.UNAUTHENTICATED
        );
    }

    @ExceptionHandler(ExpiredTokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleExpiredTokenError() {
        return new ErrorResponse(
                ErrorStatus.UNAUTHORIZED_EXPIRED_TOKEN,
                ErrorMessage.EXPIRED_TOKEN
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInternalServerError(final Exception exception) {
        log.warn("Internal Error log", exception);
        return new ErrorResponse(
                ErrorStatus.INTERNAL_SERVER_ERROR,
                ErrorMessage.INTERNAL_SERVER_ERROR
        );
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final int internalStatusCode = status.value() * 10;
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
