package umc.nnmrm.apiPayload.exception.handler;

import umc.nnmrm.apiPayload.code.BaseErrorCode;
import umc.nnmrm.apiPayload.code.status.ErrorStatus;
import umc.nnmrm.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
