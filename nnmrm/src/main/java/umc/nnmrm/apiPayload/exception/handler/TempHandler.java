package umc.nnmrm.apiPayload.exception.handler;

import umc.nnmrm.apiPayload.code.BaseErrorCode;
import umc.nnmrm.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}