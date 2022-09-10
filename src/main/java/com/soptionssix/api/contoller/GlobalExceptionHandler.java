package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.ErrorResponse;
import com.soptionssix.domain.error.ErrorCode;
import com.soptionssix.domain.error.SoptionsException;
import com.soptionssix.env.RunEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final RunEnvironment runEnvironment;

    @Autowired
    public GlobalExceptionHandler(RunEnvironment runEnvironment) {
        this.runEnvironment = runEnvironment;
    }

    @ExceptionHandler(SoptionsException.BadRequest.class)
    public ResponseEntity<Object> handleBadRequestError(
        SoptionsException.BadRequest exception
    ) {
        return responseErrorFormat(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(SoptionsException.Unauthenticated.class)
    public ResponseEntity<Object> handleUnauthenticatedError(
        SoptionsException.Unauthenticated exception
    ) {
        return responseErrorFormat(HttpStatus.UNAUTHORIZED, exception);
    }

    @ExceptionHandler(SoptionsException.ExpiredToken.class)
    public ResponseEntity<Object> handleExpiredTokenError(
        SoptionsException.ExpiredToken exception
    ) {
        return responseErrorFormat(HttpStatus.UNAUTHORIZED, exception);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleInternalServerError(final Exception exception) {
        log.warn("Internal Error log", exception);
        SoptionsException soptionsException = new SoptionsException(
            ErrorCode.INTERNAL_SERVER_ERROR,
            exception.getMessage()
        );
        return responseErrorFormat(HttpStatus.INTERNAL_SERVER_ERROR, soptionsException);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
        Exception ex, Object body,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request
    ) {
        SoptionsException soptionsException = new SoptionsException(
            status.value() * 10,
            ex.getMessage()
        );
        return this.responseErrorFormat(status, soptionsException);
    }


    private ResponseEntity<Object> responseErrorFormat(
        final HttpStatus status,
        final SoptionsException exception
    ) {
        return ResponseEntity.status(status.value())
            .body(createErrorResponseFrom(exception));
    }

    private ErrorResponse createErrorResponseFrom(SoptionsException exception) {
        String errorMessage = this.runEnvironment.isProduct() ? exception.getClass().getSimpleName()
            : exception.getMessage();
        return new ErrorResponse(exception.getErrorCode(), errorMessage);
    }
}
