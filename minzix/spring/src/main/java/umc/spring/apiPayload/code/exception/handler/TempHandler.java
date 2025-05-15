package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.exception.BaseErrorCode;
import umc.spring.apiPayload.code.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}