package umc.spring.apiPayload.code.status;

import umc.spring.apiPayload.code.dto.ReasonDTO;

public interface BaseCode {

    ReasonDTO getReason();
    ReasonDTO getReasonHttpStatus();
}
