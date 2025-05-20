package umc.spring.apiPayload.code.status;

import umc.spring.apiPayload.code.dto.ErrorReasonDTO;

public interface BaseErrorCode {

    ErrorReasonDTO getReason();
    ErrorReasonDTO getReasonHttpStatus();
}
