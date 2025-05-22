package umc.spring.dto.memberMission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class MemberMissionDto {
    private Long userMissionId;
    private MissionStatus missionStatus;
    private Integer reward;
    private String missionContent;
    private LocalDateTime createdAt;
}
