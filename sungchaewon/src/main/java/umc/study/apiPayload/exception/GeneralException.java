package umc.study.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;

    // 예외 코드 객체 자체를 리턴 (예: GlobalExceptionHandler에서 활용)
    public BaseErrorCode getErrorCode() {
        return this.code;
    }

    // 간단한 메시지 응답용
    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    // HTTP 상태 포함된 메시지 응답용
    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}