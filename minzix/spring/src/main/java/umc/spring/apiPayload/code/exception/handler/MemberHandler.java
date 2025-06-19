package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.status.BaseErrorCode;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
