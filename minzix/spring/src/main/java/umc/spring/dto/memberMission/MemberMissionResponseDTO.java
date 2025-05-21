package umc.spring.dto.memberMission;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    public static class InProgressMissionDTO {
        private String missionSpec;
        private Integer reward;
        private String storeName;
        private String missionStatus;
    }

    @Getter
    @Builder
    public static class InProgressMissionListDTO {
        private boolean isFirst;
        private boolean isLast;
        private int totalPage;
        private long totalElements;
        private int listSize;
        private List<InProgressMissionDTO> missionList;
    }
}