package com.shoppingCart.ShoppingCart.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final String errMsgKey;
    private final String errorCode;

    public ResourceNotFoundException(ErrorCode code) {
        super(code.getErrMsgKey());
        this.errMsgKey = code.getErrMsgKey();
        this.errorCode = code.getErrCode();
    }

    public ResourceNotFoundException(final String message) {
        super(message);
        this.errMsgKey = ErrorCode.RESOURCE_NOT_FOUND.getErrMsgKey();
        this.errorCode = ErrorCode.RESOURCE_NOT_FOUND.getErrCode();
    }
}
