package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.enums.MemberMissionStatus;
import umc.spring.validation.annotation.ExistMember;

public class MemberMissionRequestDTO {

    @Getter
    public static class JoinDTO {
        @ExistMember
        private Long memberId;
    }
}
