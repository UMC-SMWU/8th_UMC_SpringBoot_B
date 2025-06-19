package umc.study.apiPayload.exception.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDTO;

@Getter
public enum MemberHandler implements BaseErrorCode {

    GENDER_REQUIRED("MEMBER_001", "성별은 필수입니다.", HttpStatus.BAD_REQUEST),
    INVALID_GENDER("MEMBER_002", "유효하지 않은 성별 값입니다.", HttpStatus.BAD_REQUEST);

    private final ErrorReasonDTO errorReasonDTO;

    MemberHandler(String code, String message, HttpStatus status) {
        this.errorReasonDTO = ErrorReasonDTO.builder()
                .code(code)
                .message(message)
                .httpStatus(status)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReason() {
        return errorReasonDTO;
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return errorReasonDTO;
    }
}
