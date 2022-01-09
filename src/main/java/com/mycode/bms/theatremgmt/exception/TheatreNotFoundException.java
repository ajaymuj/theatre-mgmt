package com.mycode.bms.theatremgmt.exception;

import org.springframework.http.HttpStatus;

public class TheatreNotFoundException extends RuntimeException {

    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public static final String THEATRE_NOTFOUND_ERROR = "Theatre not found!";

    public TheatreNotFoundException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


    private static String getErrorMsg(Exception exception) {
        Throwable cause = exception.getCause();
        if (cause instanceof TheatreNotFoundException) {
            return THEATRE_NOTFOUND_ERROR;
        }
        return exception.getMessage();
    }

}
