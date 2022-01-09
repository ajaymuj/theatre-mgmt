package com.mycode.bms.theatremgmt.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = { TheatreNotFoundException.class })
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ResponseEntity handleException(TheatreNotFoundException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(createErrorResponse(e.getHttpStatus(), e));
    }

    public static Throwable getRootCause(Throwable throwable) {
        Throwable cause;
        while ((cause = throwable.getCause()) != null) {
            throwable = cause;
        }
        return throwable;
    }

    static public String generateRandomErrorCode() {
        return UUID.randomUUID().toString();
    }

    public com.mycode.bms.theatremgmt.exception.ErrorResponse createErrorResponse(HttpStatus httpStatus, Exception e) {
        Throwable rootCause = getRootCause(e);
        String rootErrorMsg = rootCause == e ? null : rootCause.getMessage();
        String logRefCode = generateRandomErrorCode();
        log.error("errorRefCode: {}", logRefCode, e);

        return new com.mycode.bms.theatremgmt.exception.ErrorResponse(httpStatus.value(),
                ServiceErrorCode.GLOBAL_INTERNAL_ERROR.getErrorCode(),
                e.getMessage(),
                rootErrorMsg,
                null,
                logRefCode);
    }

}
