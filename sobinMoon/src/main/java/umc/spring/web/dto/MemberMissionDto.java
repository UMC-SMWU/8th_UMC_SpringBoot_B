package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import umc.spring.domain.enums.MemberMissionStatus;

@Getter
@AllArgsConstructor
@ToString
public class MemberMissionDto {


    private Long memberMissionId;
    private MemberMissionStatus missionStatus;
    private Integer reward;
    private String missionSpec;
    private String storeName;
}
