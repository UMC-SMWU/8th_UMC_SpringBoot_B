package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class InvalidPageHandler extends GeneralException {
    public InvalidPageHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

