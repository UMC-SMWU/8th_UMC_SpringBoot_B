package umc.study.apiPayload.exception.handler;

import lombok.Getter;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDTO;

@Getter
public class MemberHandler extends RuntimeException {

    private final BaseErrorCode baseErrorCode;

    public MemberHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode.getReason().getMessage());
        this.baseErrorCode = baseErrorCode;
    }

    public ErrorReasonDTO getReason() {
        return baseErrorCode.getReason();
    }

    public ErrorReasonDTO getReasonHttpStatus() {
        return baseErrorCode.getReasonHttpStatus();
    }
}
