package umc.study.apiPayload.exception.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDTO;



/*
 Enum으로 처리한 이유
  - BaseErrorCode를 구현하여 공통적인 에러 응답 형식을 따름
  - 각각의 에러를 상수로 정의함으로써 재사용성과 유지보수성을 높임
  - 에러 메시지, 코드, HTTP 상태를 일관되게 관리할 수 있음
*/


@Getter
public enum MissionHandler implements BaseErrorCode {

    MISSION_NOT_FOUND("MISSION_001", "존재하지 않는 미션입니다.", HttpStatus.NOT_FOUND),
    ALREADY_CHALLENGED("MISSION_002", "이미 도전한 미션입니다.", HttpStatus.CONFLICT),
    MEMBER_NOT_FOUND("MISSION_003", "존재하지 않는 회원입니다.", HttpStatus.NOT_FOUND);

    private final ErrorReasonDTO errorReasonDTO;

    MissionHandler(String code, String message, HttpStatus status) {
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
