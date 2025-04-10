package com.unid.unidatebe.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum RestErrorCodeEnum {
    GENERIC_EXCEPTION_WITHOUT_PARAMETERS("Generic error", HttpStatus.INTERNAL_SERVER_ERROR),
    GENERIC_EXCEPTION_WITH_PARAMETERS("Generic errore {}", HttpStatus.INTERNAL_SERVER_ERROR);

    private String message;
    private HttpStatus status;

    private RestErrorCodeEnum(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
