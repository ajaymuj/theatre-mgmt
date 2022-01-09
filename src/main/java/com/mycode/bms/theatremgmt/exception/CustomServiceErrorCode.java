package com.mycode.bms.theatremgmt.exception;

import org.springframework.http.HttpStatus;

public class CustomServiceErrorCode extends ServiceErrorCode {

    final public static ServiceErrorCode USER_NOT_FOUND
            = new CustomServiceErrorCode("THEATRE_NOT_FOUND",
            HttpStatus.NOT_FOUND, "Theatre not found");
    final public static ServiceErrorCode ROLE_NOT_FOUND
            = new CustomServiceErrorCode("MOVIE_NOT_FOUND",
            HttpStatus.NOT_FOUND, "Movie not found");

    protected CustomServiceErrorCode(String errorCode, HttpStatus httpStatus, String defaultMessage) {
        super(errorCode, httpStatus, defaultMessage);
    }
}
