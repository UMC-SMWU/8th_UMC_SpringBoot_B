package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OngoingMissionDTO {
    private Long missionId;
    private String missionSpec;
    private Integer reward;
    private LocalDate deadline;
    private String storeName;
}
