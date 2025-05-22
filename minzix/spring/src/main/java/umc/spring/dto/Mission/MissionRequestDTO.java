package umc.spring.dto.Mission;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MissionRequestDTO {
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
    private Long storeId;
}