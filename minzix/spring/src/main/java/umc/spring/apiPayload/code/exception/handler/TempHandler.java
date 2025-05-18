package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.status.BaseErrorCode;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}