package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.status.BaseErrorCode;

public class InvalidPageException extends GeneralException {

    public InvalidPageException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

