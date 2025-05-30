package umc.study.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MissionRequestDTO {

    @NotBlank(message = "미션 내용은 필수입니다.")
    private String missionSpec;

    @NotBlank(message = "보상 내용은 필수입니다.")
    private Integer reward;

    @NotNull(message = "마감일은 필수입니다.")
    @Future(message = "마감일은 미래여야 합니다.")
    private LocalDate deadline;

    @NotNull(message = "가게 ID는 필수입니다.")
    private Long storeId;
}
