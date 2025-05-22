package umc.nnmrm.apiPayload.exception.handler;

import umc.nnmrm.apiPayload.code.BaseErrorCode;
import umc.nnmrm.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
