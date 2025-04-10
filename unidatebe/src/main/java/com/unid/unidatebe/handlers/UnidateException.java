package com.unid.unidatebe.handlers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.unid.unidatebe.enums.RestErrorCodeEnum;
import lombok.Getter;

@Getter
public class UnidateException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    private final String message;
    private final String callingMethod;
    private final HttpStatus status;
    private final List<String> messageParameters = new LinkedList<>();

    //TODO - Devi creare gli altri costruttori

    public UnidateException(RestErrorCodeEnum errorCodeEnum, String callingMethod){
        super(errorCodeEnum.getMessage());
        this.message = errorCodeEnum.getMessage();
        this.status = errorCodeEnum.getStatus();
        this.callingMethod = callingMethod;
    }
}
