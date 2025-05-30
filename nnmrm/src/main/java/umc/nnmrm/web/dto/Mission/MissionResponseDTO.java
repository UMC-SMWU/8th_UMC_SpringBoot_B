package umc.nnmrm.web.dto.Mission;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionResponseDTO {

    private Long missionId;
    private LocalDateTime createdAt;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionDTO {
        private Long missionId;
        private String missionSpec;
        private Integer reward;
        private LocalDate deadline;
        private String storeName;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionListDTO {
        private List<MyMissionDTO> missions;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}