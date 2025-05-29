package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionListDTO {
    private List<MissionDTO> missionList;
    private Integer listSize;
    private Integer totalPage;
    private Long totalElements;
    private Boolean isFirst;
    private Boolean isLast;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionDTO {
        private Long id;
        private String spec;
        private String reward;
        private String status;
    }
}
