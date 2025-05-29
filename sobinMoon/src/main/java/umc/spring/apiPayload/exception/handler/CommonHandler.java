package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class CommonHandler extends GeneralException {
    public CommonHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
