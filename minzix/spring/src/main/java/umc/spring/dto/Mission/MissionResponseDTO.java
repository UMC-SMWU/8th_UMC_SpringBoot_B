package umc.spring.dto.Mission;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Getter
    @Builder
    public static class MissionDTO {
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    public static class MissionListDTO {
        private boolean isFirst;
        private boolean isLast;
        private int totalPage;
        private long totalElements;
        private int listSize;
        private List<MissionDTO> missionList;
    }
}
