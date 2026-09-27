package com.lsp.pricingservice.application.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private final ErrorCode errorCode;
    private final Object[] parameters;

    public ServiceException(ErrorCode errorCode, Object... parameters) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.parameters = parameters;
    }

}
