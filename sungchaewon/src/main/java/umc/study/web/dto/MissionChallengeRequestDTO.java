package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class MissionChallengeRequestDTO {

    @NotNull(message = "도전하려는 missionId는 필수입니다.")
    private Long missionId;

    // 하드코딩된 memberId를 서비스에서 사용할 예정
}
