package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.status.BaseErrorCode;

public class MemberMissionHandler extends GeneralException {
    public MemberMissionHandler(BaseErrorCode code) {
        super(code);
    }
}