package umc.nnmrm.apiPayload.exception.handler;

import umc.nnmrm.apiPayload.code.BaseErrorCode;
import umc.nnmrm.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
