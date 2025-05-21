package umc.nnmrm.web.dto.MemberMission;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MissionChallengeResponseDTO {
    private Long memberMissionId;
    private String status;
    private LocalDateTime createdAt;
}
