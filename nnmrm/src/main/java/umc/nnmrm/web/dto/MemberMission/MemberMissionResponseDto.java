package umc.nnmrm.web.dto.MemberMission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor
public class MemberMissionResponseDto {
    private Long memberMissionId;
    private String status;
    private LocalDateTime createdAt;
    private Long missionId;
    private Integer reward;
    private String missionSpec;
    private String storeName;
    private String cursorValue;
}